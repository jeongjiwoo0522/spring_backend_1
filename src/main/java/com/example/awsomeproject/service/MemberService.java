package com.example.awsomeproject.service;

import com.example.awsomeproject.domain.Member;
import com.example.awsomeproject.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     * @param member
     * @return
     */
    @Transactional
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
