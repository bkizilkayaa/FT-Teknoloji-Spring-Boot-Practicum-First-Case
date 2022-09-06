package com.example.springpracticum.first_case.service;

import com.example.springpracticum.first_case.exception.ProductNotFoundById;
import com.example.springpracticum.first_case.model.Product;
import com.example.springpracticum.first_case.model.ProductComment;
import com.example.springpracticum.first_case.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCommentService productCommentService;


    public ProductService(ProductRepository productRepository, ProductCommentService productCommentService) {
        this.productRepository = productRepository;
        this.productCommentService = productCommentService;
    }



    public Product addProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(int product_id) {
        return productRepository.findById(product_id)
                .orElseThrow(()-> new ProductNotFoundById("product not found by id : "+product_id));
    }

    public List<String> getCommentsForGivenProductId(int product_id) {
        findProductById(product_id); //responses 404 error if product not found.
        return productCommentService.getCommentsForGivenProductId(product_id);
    }

    public List<Product> getProductsWhichIsExpired() {
        try {
            return productRepository.getProductsWhichIsExpired(getCurrentDateWithFormatted());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Product> getProductsWhichIsNotExpired() {
        try {
            return productRepository.getProductsWhichIsNotExpired(getCurrentDateWithFormatted());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //şuanki tarih saat bilgisinin database'deki tarih saatformatına dönüştürülmesi.
    //formats current date same as database
    private Date getCurrentDateWithFormatted(){
        try {        Date time=new Date();
            SimpleDateFormat format=new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss.SSSSSS"));
            Date temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS")
                    .parse(format.format(time));
            return temp;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private Date getCurrentDateWithFormatted(Date date){
        try {
            SimpleDateFormat format=new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss.SSSSSS"));
            Date temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS")
                    .parse(format.format(date));
            return temp;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProductComment> productSearchBetweenDates(Date minDate, Date maxDate, int product_id) {
        return productCommentService.
                productSearchBetweenDates(
                        getCurrentDateWithFormatted(minDate),
                        getCurrentDateWithFormatted(maxDate),
                        product_id);
    }
}
