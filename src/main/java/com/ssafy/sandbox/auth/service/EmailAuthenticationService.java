package com.ssafy.sandbox.auth.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ssafy.sandbox.auth.domain.EmailAuthenticationToken;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailAuthenticationService {
	private final JavaMailSender mailSender;

	public void sendAuthenticationEmail(String toEmail, EmailAuthenticationToken emailAuthenticationToken) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject("이메일 인증");
		message.setText("인증 코드: " + emailAuthenticationToken.getVerificationCode());

		mailSender.send(message);
	}
}
