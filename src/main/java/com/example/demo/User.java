package com.example.demo; // 패키지 경로 일치시킬것

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // DB 테이블과 매핑하는 엔티티
@Table(name = "users")
@Getter // Getter 메소드가 필요할 수 있다고 한다...
@NoArgsConstructor // 파라미터가 없는 기본 생성자를 자동으로 생성할 때 사용
public class User {

    @Id // 기본키 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 자동으로 증가
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    // 회원가입 시 사용하는 생성자
    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
}