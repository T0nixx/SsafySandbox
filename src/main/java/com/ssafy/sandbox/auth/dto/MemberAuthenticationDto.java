package com.ssafy.sandbox.auth.dto;

import java.time.LocalDateTime;
import java.util.Random;

import lombok.Data;

@Data
public class MemberAuthenticationDto {
	private String email;
	private String verificationCode;
	private LocalDateTime expiryTime;

	public MemberAuthenticationDto(String email) {
		this.email = email;
		this.verificationCode = String.valueOf(generateVerificationCode());
		this.expiryTime = LocalDateTime.now().plusMinutes(5); // 5분 후 만료
	}

	public boolean isExpired() {
		return LocalDateTime.now().isAfter(this.expiryTime);
	}

	private int generateVerificationCode() {
		return 100000 + new Random().nextInt(900000); // 100000 ~ 999999 사이의 난수
	}
}
