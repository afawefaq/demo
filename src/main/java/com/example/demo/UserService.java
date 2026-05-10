package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public String signup(UserRequestDto requestDto) {
        // 존재하는 아이디 여부 먼저 확인
        if (userRepository.findByUsername(requestDto.getUsername()) != null) {
            return "이미 존재하는 아이디입니다.";
        }

        // 엔티티 생성 및 저장
        // jwt를 위한 비밀번호 암호화 추가할 것
        User user = new User(requestDto.getUsername(), requestDto.getPassword(), requestDto.getName());
        userRepository.save(user);

        return "회원가입이 완료되었습니다.";
    }
}