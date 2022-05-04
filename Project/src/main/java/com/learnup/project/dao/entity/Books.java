package com.learnup.project.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Книга - ид книги, название книги, годе издания, количество страниц, цена, ид автора, ид в складе
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(schema = "schema")
public class Books implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String title;
    
    @Column(nullable = false)
    private LocalDate yearOfPublication;
    
    @Min(value = 0)
    @Column(nullable = false)
    private Long numberOfPages, price;
    
    @JoinColumn
    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Authors author;
    
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    private BookWarehouse bookWarehouse;
    
}
