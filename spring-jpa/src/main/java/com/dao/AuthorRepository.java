package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {

}
