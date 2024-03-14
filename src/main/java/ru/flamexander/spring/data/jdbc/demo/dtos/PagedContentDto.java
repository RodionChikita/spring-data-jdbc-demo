package ru.flamexander.spring.data.jdbc.demo.dtos;

import lombok.*;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PagedContentDto<T> {
    private List<T> content;
    private Integer pageNumber;
    private Integer pageSize;
    @Getter(AccessLevel.NONE)
    private Integer pagesQuantity;
    private Integer booksQuantity;

    public Integer getPagesQuantity() {
        return Math.ceilDiv(booksQuantity, pageSize);
    }

}
