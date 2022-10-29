package com.example.myrestapi.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeEnum {

    SUCCESS("0000","SUCCESS"),
    NO_VALUE("1000", "값을 조회하지 못했습니다."),
    UNKNOWN_ERROR("9999", "UNKNOWN_ERROR");

    private String code;
    private String message;
}
