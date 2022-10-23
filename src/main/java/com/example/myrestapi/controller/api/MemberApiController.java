package com.example.myrestapi.controller.api;
import com.example.myrestapi.entity.MemberEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = {"Member API입니다"})
@RequiredArgsConstructor
@RestController
public class MemberApiController {

    @ApiOperation(value = "회원 가입", notes = "회원을 등록합니다")
    @PostMapping("/member")
    public MemberEntity join() {

        return new MemberEntity("a","b","c","d");
    }
}
