package com.ssafy.sandbox.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.sandbox.auth.domain.EmailAuthenticationToken;
import com.ssafy.sandbox.auth.dto.AuthenticationRequestDto;
import com.ssafy.sandbox.auth.dto.AuthenticationResponseDto;
import com.ssafy.sandbox.auth.dto.SendAuthenticationRequestDto;
import com.ssafy.sandbox.auth.dto.SendAuthenticationResponseDto;
import com.ssafy.sandbox.auth.service.EmailAuthenticationService;
import com.ssafy.sandbox.auth.service.EmailTokenService;
import com.ssafy.sandbox.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class AuthController {
	private final MemberService memberService;
	private final EmailAuthenticationService emailAuthenticationService;
	private final EmailTokenService emailTokenService;

	@PostMapping
	public ResponseEntity<SendAuthenticationResponseDto> sendAuthentication(
		@RequestBody SendAuthenticationRequestDto sendAuthenticationRequestDto) {
		String email = sendAuthenticationRequestDto.getEmail();
		EmailAuthenticationToken emailAuthenticationToken = new EmailAuthenticationToken(
			sendAuthenticationRequestDto.getEmail());
		emailTokenService.storeUser(emailAuthenticationToken);
		emailAuthenticationService.sendAuthenticationEmail(email, emailAuthenticationToken);
		return ResponseEntity.ok(new SendAuthenticationResponseDto());
	}

	@PostMapping("/authentication")
	public ResponseEntity<AuthenticationResponseDto> authenticateUser(
		@RequestBody AuthenticationRequestDto authenticationRequestDto) {
		String email = authenticationRequestDto.getEmail();
		EmailAuthenticationToken emailAuthenticationToken = emailTokenService.retrieveUser(email);
		if (emailAuthenticationToken == null
			|| !emailAuthenticationToken.getVerificationCode().equals(authenticationRequestDto.getAuthentication())) {
			return ResponseEntity.ok(new AuthenticationResponseDto(Boolean.FALSE));
		}

		memberService.registerUser(email);
		emailTokenService.removeUser(email);

		return ResponseEntity.ok(new AuthenticationResponseDto(Boolean.TRUE));
	}

}
