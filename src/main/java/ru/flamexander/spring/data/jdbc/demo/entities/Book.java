package ru.flamexander.spring.data.jdbc.demo.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
@Getter
@Setter
@Table("books")
public class Book {
    @Id
    private Long id;
    private String title;
    private Long authorId;
    private Genre genre;
    @MappedCollection(idColumn = "BOOK_ID")
    private BookDetails bookDetails;

    @PersistenceCreator
    public Book(Long id, String title, Long authorId, BookDetails bookDetails) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.bookDetails = bookDetails;
    }
}
