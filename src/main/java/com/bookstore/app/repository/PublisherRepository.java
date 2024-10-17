package com.bookstore.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.app.models.PublisherModel;


public interface PublisherRepository extends JpaRepository<PublisherModel, UUID> {
}
