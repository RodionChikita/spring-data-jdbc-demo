package ru.flamexander.spring.data.jdbc.demo.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.Date;
@Table("reviews")
@Getter
@Setter
public class Review {
    @Id
    private Long id;
    private String userName;
    private String reviewText;
    private byte grade;
    private Date createdAt;
    private Long bookId;
    @PersistenceCreator
    public Review(Long id, String userName, String reviewText, byte grade, Date createdAt, Long bookId) {
        this.userName = userName;
        this.bookId = bookId;
        this.id = id;
        this.grade = grade;
        this.createdAt = createdAt;
        this.reviewText =reviewText;
    }
}
