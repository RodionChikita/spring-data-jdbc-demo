package ru.flamexander.spring.data.jdbc.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateReviewDtoRq {
    private Long id;
    private String userName;
    private String reviewText;
    private byte grade;
    private Date createdAt;
    private Long bookId;
}
