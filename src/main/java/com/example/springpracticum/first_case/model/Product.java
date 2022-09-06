package com.example.springpracticum.first_case.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name="product_name")
    private String productName;

    @Column(name = "price")
    private double price;

    @Temporal(TemporalType.DATE)
    private Date expireDate;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "product")
    private List<ProductComment> productCommentList;


}
