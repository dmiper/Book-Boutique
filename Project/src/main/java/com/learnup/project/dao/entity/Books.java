package com.learnup.project.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Книга - информация о названии, ид автора, годе издания, количестве страниц, цене
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
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Authors author;
    
    @OneToOne(cascade = CascadeType.PERSIST,optional = false, fetch = FetchType.LAZY)
    private BookWarehouse bookWarehouse;
    
}
