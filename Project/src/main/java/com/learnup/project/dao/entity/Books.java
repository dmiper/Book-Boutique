package com.learnup.project.dao.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Книга - информация о названии, ид автора, годе издания, количестве страниц, цене
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "schema")
public class Books implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private LocalDate yearOfPublication;
    
    @Min(value = 0)
    @Column(nullable = false)
    private Long numberOfPages;
    
    @Min(value = 0)
    @Column(nullable = false)
    private Long price;
    
    @JoinColumn
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Authors> author;
    
    public Books(Long id, String title, List<Authors> author, LocalDate yearOfPublication, Long numberOfPages, Long price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }
    
    public Books(Long id, String title, LocalDate yearOfPublication, Long numberOfPages, Long price) {
        this.id = id;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }
}
