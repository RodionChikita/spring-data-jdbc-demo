package ru.flamexander.spring.data.jdbc.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.flamexander.spring.data.jdbc.demo.dtos.DetailedBookDto;
import ru.flamexander.spring.data.jdbc.demo.dtos.PagedContentDto;
import ru.flamexander.spring.data.jdbc.demo.dtos.SimplestPageDto;
import ru.flamexander.spring.data.jdbc.demo.services.BooksService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public PagedContentDto<DetailedBookDto> findAllDetailedBooks(@RequestParam(required = false) Integer page, @RequestParam(name = "page-size", required = false) Integer pageSize) {
        return booksService.findPageDetailedBooks(page, pageSize);
    }

    @PatchMapping("/{id}/title")
    public void updateTitleById(@PathVariable Long id, @RequestParam String value) {
        booksService.updateTitleById(id, value);
    }
    @GetMapping("/top10")
    public SimplestPageDto<DetailedBookDto> getTop10() {
        SimplestPageDto<DetailedBookDto> pageDto = new SimplestPageDto<DetailedBookDto>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date lastMonthDate = calendar.getTime();
        pageDto.setContent(booksService.findTopByPeriod(10, lastMonthDate));
        return pageDto;
    }
}
