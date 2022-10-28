package com.example.myrestapi.service;

import com.example.myrestapi.dto.request.MemberRequestDto;
import com.example.myrestapi.dto.response.MemberResponseDto;
import com.example.myrestapi.entity.MemberEntity;
import com.example.myrestapi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

//    public MemberEntity findMember(String memberId) {
//        Optional<MemberEntity> member = memberRepository.findById(memberId);
//        if (member.isPresent()) {
//            return member.get();
//        }
//        throw new NullPointerException("해당하는 Member가 없습니다");
//    }

    public List<MemberEntity> findMembers() {
        List<MemberEntity> members = memberRepository.findAll();
        return members;
    }

    public MemberResponseDto save(MemberRequestDto request) {
        MemberEntity save = memberRepository.save(request.toEntity());
        System.out.println(save.getId());
        System.out.println(save.getMemberId());
        System.out.println(save.getPassword());
        MemberEntity entity = memberRepository.findByMemberId(request.getMemberId()).get();
        return new MemberResponseDto(entity);
    }
}
