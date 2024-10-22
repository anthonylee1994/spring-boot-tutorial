package com.learn.springboottutorial.service.review;

import com.learn.springboottutorial.model.Review;
import com.learn.springboottutorial.request.ReviewUpdateRequest;
import org.springframework.data.domain.Page;

/**
 * @author anthonylee
 */
public interface IReviewService {
    Review saveReview(Review review, Long reviewerId, Long veterinarianId);

    double getAverageRatingForVet(Long veterinarianId);

    Review updateReview(Long reviewerId, ReviewUpdateRequest review);

    Page<Review> findAllReviewsByUserId(Long userId, int page, int size);

    void deleteReview(Long reviewerId);
}
