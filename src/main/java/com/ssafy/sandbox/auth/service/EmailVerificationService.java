package com.ssafy.sandbox.auth.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ssafy.sandbox.auth.dto.MemberAuthenticationDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailVerificationService {
	private final JavaMailSender mailSender;

	public void sendVerificationEmail(String toEmail, MemberAuthenticationDto memberAuthenticationDto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject("이메일 인증");
		message.setText("인증 코드: " + memberAuthenticationDto.getVerificationCode());

		mailSender.send(message);
	}
}
