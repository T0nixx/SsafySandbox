package com.ssafy.sandbox.auth.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.ssafy.sandbox.auth.dto.MemberAuthenticationDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailTokenService {
	private final Map<String, MemberAuthenticationDto> temporaryMembers = new ConcurrentHashMap<>();

	public void storeUser(MemberAuthenticationDto temporaryUser) {
		temporaryMembers.put(temporaryUser.getEmail(), temporaryUser);
	}

	public MemberAuthenticationDto retrieveUser(String token) {
		MemberAuthenticationDto memberVerificationDto = temporaryMembers.get(token);
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

