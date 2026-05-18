package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public String signup(UserRequestDto requestDto) {
        // 아이디 존재 여부 확인
        if (userRepository.findByUsername(requestDto.getUsername()) != null) {
            return "이미 존재하는 아이디 입니다.";
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        // encodedPassword 저장
        User user = new User(requestDto.getUsername(), encodedPassword, requestDto.getName());
        userRepository.save(user);

        return "회원가입 완료.";
    }
}