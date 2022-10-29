package com.example.myrestapi.controller.api;

import com.example.myrestapi.common.response.CommonResponse;
import com.example.myrestapi.dto.request.MemberRequestDto;
import com.example.myrestapi.dto.response.MemberResponseDto;
import com.example.myrestapi.entity.MemberEntity;
import com.example.myrestapi.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = {"Member API입니다"})
@RequiredArgsConstructor
@RestController
public class MemberApiController {
    private final MemberService memberService;

    @ApiOperation(value = "회원 단건 검색", notes = "회원 한건을 조회합니다")
    @GetMapping("/member/{memberId}")
    public CommonResponse<MemberResponseDto> findMember(@PathVariable String memberId) {
        MemberResponseDto member = memberService.findMember(memberId);
        return new CommonResponse(member);
    }

    @ApiOperation(value = "전체 회원 검색", notes = "전체 회원을 조회합니다")
    @GetMapping("/member")
    public CommonResponse<List<MemberEntity>> findMembers() {
        List<MemberEntity> members = memberService.findMembers();
        List<MemberRequestDto> collect = members.stream()
                .map(m -> new MemberRequestDto(m.getMemberId(), m.getPassword(), m.getName(), m.getEmail()))
                .collect(Collectors.toList());
        return new CommonResponse(collect);
    }

    @ApiOperation(value = "회원 가입", notes = "회원을 등록합니다")
    @PostMapping("/member")
    public CommonResponse<MemberResponseDto> save(@RequestBody MemberRequestDto request) { //@RequestBody가 없으면 json 데이터를 api로 보낼 시 결과값 받지 못함
        MemberResponseDto responseDto = memberService.save(request);
        return new CommonResponse(responseDto);
    }
}
