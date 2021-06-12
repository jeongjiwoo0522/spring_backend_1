package com.example.awsomeproject.service;

import com.example.awsomeproject.domain.Member;
import com.example.awsomeproject.repository.MemberRepository;
import com.example.awsomeproject.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     * @param member
     * @return
     */
    public Long join(Member member) {
        // 같은 이름의 회원 중복 X
        validateDuplicateMember(member);

        Member newMember = memberRepository.save(member);
        return newMember.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long  memberId) {
        return memberRepository.findById(memberId);
    }
}
