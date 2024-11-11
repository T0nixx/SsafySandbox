package com.ssafy.sandbox.auth.dto;

import lombok.Data;

@Data
public class EmailAuthenticationRequestDto {
	private String authentication;
	private String email;
}
