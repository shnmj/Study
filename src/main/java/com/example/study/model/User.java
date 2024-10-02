package com.example.study.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity  // User 클래스가 MySql에 테이블 생성됨
public class User {

    @Id  // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에 연결된 DB의 넘버링 전략을 따라감
    private int id; // 시퀀스(오라클), auto_increment(MySql: 넘버링 전략)

    @Column(nullable = false, length = 30)
    private String username; // 아이디

    @Column(nullable = false, length = 100) // 1234 -> Hash(암호화)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault(" 'user' ") // 문자를 알리기 위해 홑따옴표도 같이 추가
    private String role;  // Enum 사용이 좋음 -> 어떤 데이터의 도메인(범위가 정해짐 Ex:성별=남여) 생성해줌 -> 권한 부여

    @CreationTimestamp // 시간 자동 입력
    private Timestamp createDate;
}
