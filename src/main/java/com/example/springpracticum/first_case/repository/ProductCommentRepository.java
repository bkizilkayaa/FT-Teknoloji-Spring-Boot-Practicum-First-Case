package com.example.springpracticum.first_case.repository;

import com.example.springpracticum.first_case.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductComment, Integer> {

    @Query("select a from ProductComment a where a.product.Id=?1")
    List<ProductComment> getCommentsForGivenProductId(int product_id);

    @Query("select a from ProductComment a where a.user.Id=?1")
    List<ProductComment> getUserComments(int user_id);


    @Query("select a from ProductComment a where " +
            "a.commentDate >= :startDate and " +
            "a.commentDate<=:endDate and a.product.Id=:product_id")
    List<ProductComment> productSearchBetweenDates(@Param("startDate")Date minDate,
                                                   @Param("endDate")Date maxDate,
                                                   @Param("product_id")int product_id);


    @Query("select a from ProductComment a where " +
            "a.commentDate >= :startDate and " +
            "a.commentDate<=:endDate and a.user.Id=:user_id")
    List<ProductComment> getCommentsForGivenUser(Date startDate, Date endDate, int user_id);
}
