package com.bookstore.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.app.models.ReviewModel;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}
