package com.example.springpracticum.first_case.repository;

import com.example.springpracticum.first_case.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("select a from Product a where a.expireDate <?1")
    List<Product> getProductsWhichIsExpired(Date dateTime);

    @Query("select a from Product a where a.expireDate >?1 or a.expireDate is null ")
    List<Product> getProductsWhichIsNotExpired(Date currentDateWithFormatted);



}
