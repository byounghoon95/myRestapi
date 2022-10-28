package com.example.myrestapi.dto.response;

import com.example.myrestapi.entity.MemberEntity;
import lombok.Data;

@Data
public class MemberResponseDto {
    private String memberId;
    private String name;
    private String email;

    public MemberResponseDto(MemberEntity entity) {
        this.memberId = entity.getMemberId();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }
}
