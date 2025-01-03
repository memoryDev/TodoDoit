package dev.memory.tododoit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {

    @Column(nullable = false, updatable = false)
    @Comment(value = "생성일")
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @Comment(value = "마지막 수정일")
    private LocalDateTime updatedAt;

    // PrePersist : 엔티티가 업데이트 되기전에 시간 자동 설정
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // PreUpdate : 엔티티가 업데이트되기 전에 updateAt를 자동 설정
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
