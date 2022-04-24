package com.learnup.project.dao.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

/**
 * Книга - информация о названии, ид автора, годе издания, количестве страниц, цене
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private Long numberOfPages, price;
    
    @JoinColumn
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Authors> author;
    
    
    public Books(Long id, String title, LocalDate yearOfPublication, Long numberOfPages, Long price) {
        this.id = id;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }
    
    public <T> Books(Long id, String title, T author, LocalDate yearOfPublication, Long numberOfPages, Long price) {
        this.id = id;
        this.title = title;
        this.author = (Collection<Authors>) author;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }
    
    public Books(Long id) {
        this.id = id;
    }
}
