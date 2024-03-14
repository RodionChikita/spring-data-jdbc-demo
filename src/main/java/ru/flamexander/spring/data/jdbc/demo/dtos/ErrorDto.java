package ru.flamexander.spring.data.jdbc.demo.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
 @Getter
 @Setter
public class ErrorDto {
    private String code;
    private String message;
    private LocalDateTime date;

    public ErrorDto() {
    }

    public ErrorDto(String code, String message) {
        this.code = code;
        this.message = message;
        this.date = LocalDateTime.now();
    }
}
