package com.example.springpracticum.first_case.repository;

import com.example.springpracticum.first_case.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductComment, Integer> {

    @Query("select a from ProductComment a where a.product.Id=?1")
    List<ProductComment> getCommentsForGivenProductId(int product_id);

    @Query("select a from ProductComment a where a.user.Id=?1")
    List<ProductComment> getUserComments(int user_id);

    @Query("select a from ProductComment a where a.commentDate >?1 and a.commentDate<?2 and a.product.Id=?3")
    List<ProductComment> productSearchBetweenDates(Date minDate, Date maxDate, int product_id);
}
