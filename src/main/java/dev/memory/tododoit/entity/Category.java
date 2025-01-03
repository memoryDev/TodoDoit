package dev.memory.tododoit.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Table(name = "category")
public class Category extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment(value = "카테고리 고유ID")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Comment(value = "사용자 고유ID")
    private User user;

    @Comment(value = "카테고리 이름")
    private String name;

    @Enumerated(EnumType.STRING)
    @Comment(value = "삭제여부")
    private Deleted isDeleted;

}
