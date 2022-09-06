package com.example.springpracticum.first_case.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String surname;

    @Column(length = 50)
    private String email;

    @Column(name = "phone_number",length = 15)
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "user")

    private List<ProductComment> productCommentList;

}
