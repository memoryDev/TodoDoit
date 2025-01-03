package dev.memory.tododoit.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

@Entity
@Table(name = "todo")
public class Todo extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment(value = "Todo 고유 ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Comment(value = "할 일 제목")
    private String title;

    @Comment(value = "할 일 내용")
    private String description;

    @Comment(value = "마감 기한")
    private LocalDate dueDate;

    @Comment(value = "우선순위")
    private String Priority;

    @Enumerated(EnumType.STRING)
    @Comment(value = "완료 여부")
    private Completed completed;

    @Enumerated(EnumType.STRING)
    @Comment(value = "삭제 여부")
    private Deleted isDeleted;

}
