package ru.flamexander.spring.data.jdbc.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.flamexander.spring.data.jdbc.demo.dtos.CreateOrUpdateReviewDtoRq;
import ru.flamexander.spring.data.jdbc.demo.dtos.ReviewDto;
import ru.flamexander.spring.data.jdbc.demo.entities.Review;
import ru.flamexander.spring.data.jdbc.demo.repositories.ReviewsRepository;

import java.util.Date;
import java.util.List;

@Service
public class ReviewsService {
    private final ReviewsRepository reviewsRepository;
    @Autowired
    public ReviewsService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }
    public void createNewReview(CreateOrUpdateReviewDtoRq createOrUpdateReviewDtoRq){
        Review newReview = new Review(createOrUpdateReviewDtoRq.getId(), createOrUpdateReviewDtoRq.getUserName(), createOrUpdateReviewDtoRq.getReviewText(), createOrUpdateReviewDtoRq.getGrade(), new Date(), createOrUpdateReviewDtoRq.getBookId());
        reviewsRepository.save(newReview);
    }
    public List<ReviewDto> findAllReviews() {
        return reviewsRepository.findAllReviews();
    }
}
