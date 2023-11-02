package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity<ID> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected ID id;

    @CreatedDate
    private Instant createdAt;

}
