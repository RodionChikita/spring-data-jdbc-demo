package ru.flamexander.spring.data.jdbc.demo.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.flamexander.spring.data.jdbc.demo.dtos.ReviewDto;
import ru.flamexander.spring.data.jdbc.demo.entities.Review;

import java.util.List;

@Repository
public interface ReviewsRepository extends ListCrudRepository<Review, Long> {
    @Query(
            "select r.id, r.user_name, r.review_text, r.grade, r.created_at, r.book_id from REVIEWS r "
    )
    List<ReviewDto> findAllReviews();
}
