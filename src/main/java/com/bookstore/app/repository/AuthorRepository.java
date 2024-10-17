package com.bookstore.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.app.models.AuthorModel;


public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
}
