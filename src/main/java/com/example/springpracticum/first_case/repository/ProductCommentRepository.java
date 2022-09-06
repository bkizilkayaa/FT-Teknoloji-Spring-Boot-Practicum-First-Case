package com.example.springpracticum.first_case.repository;

import com.example.springpracticum.first_case.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductComment, Integer> {

    @Query("select a from ProductComment a where a.product.Id=?1")
    List<ProductComment> getCommentsForGivenProductId(int product_id);
}
