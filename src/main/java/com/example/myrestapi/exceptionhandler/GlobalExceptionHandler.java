package com.example.myrestapi.exceptionhandler;

import com.example.myrestapi.common.response.CommonResponse;
import com.example.myrestapi.exception.CustomException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public CommonResponse handlerCustomException(CustomException e) {
        return CommonResponse.builder()
                .returnCode(e.getReturnCode())
                .returnMessage(e.getReturnMessage())
                .build();
    }
//
//    @ExceptionHandler(Exception.class)
//    public CommonResponse handlerException(Exception e) {
//        return CommonResponse.builder()
//                .returnCode(CodeEnum.UNKNOWN_ERROR.getCode()) //캐치하지 못한 Exception들을 잡으므로 Unknown을 통해 에러 캐치
//                .returnMessage(CodeEnum.UNKNOWN_ERROR.getMessage())
//                .build();
//    }
}
