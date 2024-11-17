package com.ssafy.sandbox.auth.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.ssafy.sandbox.auth.domain.EmailAuthenticationToken;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailTokenService {
	private final Map<String, EmailAuthenticationToken> temporaryMembers = new ConcurrentHashMap<>();

	public void storeUser(EmailAuthenticationToken temporaryUser) {
		temporaryMembers.put(temporaryUser.getEmail(), temporaryUser);
	}

	public EmailAuthenticationToken retrieveUser(String token) {
		EmailAuthenticationToken memberVerificationDto = temporaryMembers.get(token);
		if (memberVerificationDto == null || memberVerificationDto.isExpired()) {
			temporaryMembers.remove(token); // 만료된 경우 삭제
			return null;
		}
		return memberVerificationDto;
	}

	public void removeUser(String token) {
		temporaryMembers.remove(token);
	}
}

