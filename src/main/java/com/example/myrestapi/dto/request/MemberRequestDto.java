package com.example.myrestapi.dto.request;

import com.example.myrestapi.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class MemberRequestDto {
    private String memberId;
    private String password;
    private String name;
    private String email;

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .memberId(memberId)
                .password(password)
                .name(getName())
                .email(email)
                .build();
    }
}
