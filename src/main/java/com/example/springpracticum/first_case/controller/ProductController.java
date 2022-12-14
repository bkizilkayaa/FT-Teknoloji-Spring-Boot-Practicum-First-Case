package com.example.springpracticum.first_case.controller;


import com.example.springpracticum.first_case.model.Product;
import com.example.springpracticum.first_case.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getAllProducts() , OK);

    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product newProduct){
        return new ResponseEntity<>(productService.addProduct(newProduct),CREATED);
    }

    @GetMapping("/{product_id}/comments")
    public List<String> getCommentsForGivenProduct(@PathVariable int product_id){
        return productService.getCommentsForGivenProductId(product_id);
    }

    @GetMapping("/expired")
    public List<Product> getProductsWhichIsExpired(){
        return productService.getProductsWhichIsExpired();
    }
    @GetMapping("/available")
    public List<Product> getProductsWhichIsNotExpired(){
        return productService.getProductsWhichIsNotExpired();
    }

    @GetMapping("/{product_id}/search")
    public List<String> productSearch(
                         @RequestParam(value="startDate",required = false) String startDate,
                         @RequestParam(value="endDate",required = false) String endDate,
                         @PathVariable int product_id) {
            List<String> searchResult=new ArrayList<>();
            productService.findProductById(product_id);

            productService.productSearchBetweenDates(
                    parseStringToDates(startDate),
                            parseStringToDates(endDate),
                                product_id)
                    .forEach(i->searchResult.add(i.getComment()));

            return searchResult;
    }

    private Date parseStringToDates(String string_date){
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            date = formatter.parse(string_date);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
