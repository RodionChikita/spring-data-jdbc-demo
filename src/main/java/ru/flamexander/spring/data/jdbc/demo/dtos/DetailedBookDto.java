package ru.flamexander.spring.data.jdbc.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.flamexander.spring.data.jdbc.demo.entities.Genre;

import java.math.BigDecimal;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DetailedBookDto {
    private Long id;
    private String title;
    private Genre genre;
    private String authorName;
    private String description;
    private BigDecimal averageGrade;
}