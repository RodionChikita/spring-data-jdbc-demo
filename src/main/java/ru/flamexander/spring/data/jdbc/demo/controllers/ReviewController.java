package ru.flamexander.spring.data.jdbc.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.flamexander.spring.data.jdbc.demo.dtos.CreateOrUpdateReviewDtoRq;
import ru.flamexander.spring.data.jdbc.demo.dtos.ReviewDto;
import ru.flamexander.spring.data.jdbc.demo.dtos.SimplestPageDto;
import ru.flamexander.spring.data.jdbc.demo.services.ReviewsService;


@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewsService reviewsService;
    @Autowired
    public ReviewController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }
    @GetMapping
    public SimplestPageDto<ReviewDto> findAllReviews() {
        return new SimplestPageDto<>(reviewsService.findAllReviews());
    }
    @PostMapping
    public void createNewReview(@RequestBody CreateOrUpdateReviewDtoRq createOrUpdateReviewDtoRq) {
        reviewsService.createNewReview(createOrUpdateReviewDtoRq);
    }
}
