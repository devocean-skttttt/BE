package com.filterrecipe.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String loginId;
    private String email;
    private String nickname;
}
