package com.ssafy.sandbox.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.sandbox.auth.dto.EmailAuthenticationRequestDto;
import com.ssafy.sandbox.auth.dto.EmailAuthenticationResponseDto;
import com.ssafy.sandbox.auth.dto.MemberAuthenticationDto;
import com.ssafy.sandbox.auth.dto.RegisterRequestDto;
import com.ssafy.sandbox.auth.dto.RegisterResponseDto;
import com.ssafy.sandbox.auth.service.EmailTokenService;
import com.ssafy.sandbox.auth.service.EmailVerificationService;
import com.ssafy.sandbox.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class AuthController {
	private final MemberService memberService;
	private final EmailVerificationService emailVerificationService;
	private final EmailTokenService emailTokenService;

	@PostMapping
	public ResponseEntity<RegisterResponseDto> register(
		@RequestBody RegisterRequestDto emailVerificationRequestDto) {
		String email = emailVerificationRequestDto.getEmail();
		MemberAuthenticationDto memberVerificationDto = new MemberAuthenticationDto(
			emailVerificationRequestDto.getEmail());
		emailTokenService.storeUser(memberVerificationDto);
		emailVerificationService.sendVerificationEmail(email, memberVerificationDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(new RegisterResponseDto());
	}

	@PostMapping("/authentication")
	public ResponseEntity<EmailAuthenticationResponseDto> authenticateUser(
		@RequestBody EmailAuthenticationRequestDto emailAuthenticationRequestDto) {
		String email = emailAuthenticationRequestDto.getEmail();
		MemberAuthenticationDto tempUser = emailTokenService.retrieveUser(email);
		if (tempUser == null
			|| !tempUser.getVerificationCode().equals(emailAuthenticationRequestDto.getAuthentication())) {
			return ResponseEntity.ok(new EmailAuthenticationResponseDto(Boolean.FALSE));
		}

		memberService.registerUser(email);
		emailTokenService.removeUser(email);

		return ResponseEntity.ok(new EmailAuthenticationResponseDto(Boolean.TRUE));
	}
}
