package com.example.myrestapi.exception;

import com.example.myrestapi.common.code.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException{
    private String returnCode;
    private String returnMessage;

    public CustomException(CodeEnum codeEnum) {
        super(codeEnum.getMessage()); //조상인 RuntimeException 의 생성자 호출
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
    }
}
