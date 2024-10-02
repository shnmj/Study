package com.example.study.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터
    private String content; // Summer Note 라이브러리 사용 예정 : <html> 태그가 섞여서 디자인됨

    @ColumnDefault("0")
    private int count; // 조회수

    @ManyToOne(fetch = FetchType.EAGER) // 연관 관계 : Many(Board) To One(User) : 한 명의 유저가 여러 글 작성 가능
    @JoinColumn(name = "userId")
    private User user; // DB는 Object 저장 안됨. Fk, java는 object 저장 가능

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy 연관관계의 주인이 아님 (FK가 아님) -> DB에 컬럼을 만들지 않음
    // @JoinColumn(name="replyId") -> 1번답변이 2개 달릴 시 (replyId 1, 2) 이렇게 되면 1정규화 위반 : db에서 하나의 값은 원자성을 가짐
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}
