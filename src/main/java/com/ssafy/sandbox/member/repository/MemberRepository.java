package com.ssafy.sandbox.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.sandbox.member.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
