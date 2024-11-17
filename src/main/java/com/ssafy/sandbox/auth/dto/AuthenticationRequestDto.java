package com.ssafy.sandbox.auth.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
	private String authentication;
	private String email;
}
