package com.example.springpracticum.first_case.repository;


import com.example.springpracticum.first_case.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
