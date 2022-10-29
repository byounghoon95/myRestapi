package com.example.myrestapi.common.response;

import com.example.myrestapi.common.code.CodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//data를 제외한 두 값은 값이 있고 data만 null이라면 응답 시 값이 있는 필드만 노출
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@AllArgsConstructor
public class CommonResponse<T> {
    private String returnCode;
    private String returnMessage;
    private T data;

    /**
     * 세가지 생성자 를 통해 어떤 방식으로 데이터를 보내든 공동된 로직으로 반환
     */
    public CommonResponse(CodeEnum codeEnum) {
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
    }

    //data만 넘기는 경우는 성공으로 간주
    public CommonResponse(T data) {
        setReturnCode(CodeEnum.SUCCESS.getCode());
        setReturnMessage(CodeEnum.SUCCESS.getMessage());
        setData(data);
    }

    //codeenum과 data를 다 보내는 경우
    public CommonResponse(CodeEnum codeEnum, T data) {
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
        setData(data);
    }
}
