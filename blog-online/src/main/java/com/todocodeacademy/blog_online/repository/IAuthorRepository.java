package com.todocodeacademy.blog_online.repository;

import com.todocodeacademy.blog_online.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<Author,Long> {
}
