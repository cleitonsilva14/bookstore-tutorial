package com.bookstore.app.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import com.bookstore.app.dto.BookRecordDto;
import com.bookstore.app.models.BookModel;
import com.bookstore.app.models.ReviewModel;
import com.bookstore.app.repository.AuthorRepository;
import com.bookstore.app.repository.BookRepository;
import com.bookstore.app.repository.PublisherRepository;

@Service
public class BookService {


    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public List<BookModel> getAllBooks(){
        return bookRepository.findAll();
    }


    @Transactional
    public BookModel saveBook(BookRecordDto bookRecordDto){
        BookModel book = new BookModel();
        book.setTitle(bookRecordDto.title());
        book.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get());
        book.setAuthors(authorRepository.findAllById(bookRecordDto.authorIds()).stream().collect(Collectors.toSet()));
        //book.setAuthors(new HashSet<>(authorRepository.findAllById(bookRecordDto.authorIds())));

        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setComment(bookRecordDto.reviewComment());
        reviewModel.setBook(book);
        book.setReview(reviewModel);

        return bookRepository.save(book);

    }


    @Transactional
    public void deleteBook(UUID id){
        bookRepository.deleteById(id);
    }


}
