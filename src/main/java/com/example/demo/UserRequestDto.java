package com.example.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
//사용자
public class UserRequestDto {
    private String username;
    private String password;
    private String name;
}