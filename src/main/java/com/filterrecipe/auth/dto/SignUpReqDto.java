package com.filterrecipe.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpReqDto {
    private String loginId;
    private String email;
    private String password;
    private String nickname;
}
