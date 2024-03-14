package ru.flamexander.spring.data.jdbc.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.flamexander.spring.data.jdbc.demo.dtos.DetailedBookDto;
import ru.flamexander.spring.data.jdbc.demo.dtos.PagedContentDto;
import ru.flamexander.spring.data.jdbc.demo.repositories.BooksRepository;

import java.util.Date;
import java.util.List;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }
    public PagedContentDto<DetailedBookDto> findPageDetailedBooks(Integer pageNumber, Integer pageSize) {
        PagedContentDto<DetailedBookDto> bookPage = new PagedContentDto<>();
        Integer bookQuantity = booksRepository.getBookQuantity();
        bookPage.setBooksQuantity(bookQuantity);
        if (pageNumber == null || pageSize == null) {
            bookPage.setPageSize(bookPage.getBooksQuantity());
            bookPage.setPageNumber(0);
            bookPage.setContent(booksRepository.findAllDetailedBooks());
        } else {
            bookPage.setPageSize(pageSize);
            bookPage.setPageNumber(pageNumber);
            bookPage.setContent(booksRepository.findPageDetailedBooks(pageNumber * pageSize, pageSize));
        }
        return bookPage;
    }

    public List<DetailedBookDto> findAllDetailedBooks() {
        return booksRepository.findAllDetailedBooks();
    }

    public void updateTitleById(Long id, String newTitle) {
        booksRepository.changeTitleById(id, newTitle);
    }
    public List<DetailedBookDto> findTopByPeriod(Integer count, Date start){
        return booksRepository.findTopReviewedBooks(count, start);
    }
}
