package com.bookstore.app.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_book")

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class BookModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String title;


    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id") // fk
    private PublisherModel publisher;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany//(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_book_author", // new table
            joinColumns = @JoinColumn(name = "book_id"), // fk
            inverseJoinColumns = @JoinColumn(name = "author_id") // fk
    )
    private Set<AuthorModel> authors = new HashSet<>();

    // With the @OneToOne default = (fetch = FetchType.LAZY)
    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private ReviewModel review;

}
