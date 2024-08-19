package com.filterrecipe.auth.service;

import com.filterrecipe.auth.dto.SignUpReqDto;
import com.filterrecipe.auth.dto.User;
import com.filterrecipe.auth.dto.UserDto;
import com.filterrecipe.auth.repository.UserRepository;
import com.filterrecipe.common.exception.CustomException;
import com.filterrecipe.common.exception.ErrorCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;

    public UserDto signUp(SignUpReqDto dto) {

        String loginId = dto.getLoginId();
        String email = dto.getEmail();
        String password = dto.getPassword();
        String nickname = dto.getNickname();

        if (loginId == null || email == null || password == null || nickname == null) {
            throw new CustomException(ErrorCode.SIGN_UP_NULL);
        }

        if (userRepository.existsByLoginId(loginId)) {
            throw new CustomException(ErrorCode.LOGIN_ID_DUPLICATED);
        }

        User user = User.builder()
                .loginId(loginId)
                .email(email)
                .nickname(nickname)
                .password(passwordEncoder.encode(password))
                .build();

        userRepository.save(user);

        return mapper.map(user, UserDto.class);
    }
}
