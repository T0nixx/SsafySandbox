package com.ssafy.sandbox.member.service;

import org.springframework.stereotype.Service;

import com.ssafy.sandbox.auth.service.EmailVerificationService;
import com.ssafy.sandbox.member.model.Member;
import com.ssafy.sandbox.member.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	private final EmailVerificationService emailVerificationService;

	@Transactional
	public void registerUser(String email) {
		memberRepository.save(Member.of(email));

	}
}