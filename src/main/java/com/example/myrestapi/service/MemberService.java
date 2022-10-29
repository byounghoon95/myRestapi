package com.example.myrestapi.service;

import com.example.myrestapi.common.code.CodeEnum;
import com.example.myrestapi.dto.request.MemberRequestDto;
import com.example.myrestapi.dto.response.MemberResponseDto;
import com.example.myrestapi.entity.MemberEntity;
import com.example.myrestapi.exception.CustomException;
import com.example.myrestapi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseDto findMember(String memberId) {
        Optional<MemberEntity> member = memberRepository.findByMemberId(memberId);
        if (member.isPresent()) {
            return new MemberResponseDto(member.get());
        } else {
            throw new CustomException(CodeEnum.NO_VALUE);
        }
    }

    public List<MemberEntity> findMembers() {
        List<MemberEntity> members = memberRepository.findAll();
        return members;
    }

    public MemberResponseDto save(MemberRequestDto request) {
        MemberEntity save = memberRepository.save(request.toEntity());
        MemberEntity entity = memberRepository.findByMemberId(request.getMemberId()).get();
        Optional<MemberEntity> optional = memberRepository.findByMemberId(request.getMemberId());
        if (optional.isPresent()) {
            return new MemberResponseDto(optional.get());
        } else {
            throw new CustomException(CodeEnum.NO_VALUE);
        }
    }
}
