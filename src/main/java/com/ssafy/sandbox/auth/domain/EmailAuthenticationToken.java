package com.ssafy.sandbox.auth.domain;

import java.time.LocalDateTime;
import java.util.Random;

import lombok.Getter;

@Getter
public class EmailAuthenticationToken {
	private final Integer DURATION_AS_MINUTE = 5;

	private final String email;
	private final String verificationCode;
	private final LocalDateTime expiryTime;

	public EmailAuthenticationToken(String email) {
		this.email = email;
		this.verificationCode = String.valueOf(generateVerificationCode());
		this.expiryTime = LocalDateTime.now().plusMinutes(DURATION_AS_MINUTE); // 5분 후 만료
	}

	public boolean isExpired() {
		return LocalDateTime.now().isAfter(this.expiryTime);
	}

	private int generateVerificationCode() {
		return 100000 + new Random().nextInt(900000); // 100000 ~ 999999 사이의 난수
	}
}
