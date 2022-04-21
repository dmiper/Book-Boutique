package com.learnup.project.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Книга - информация о названии, ид автора, годе издания, количестве страниц, цене
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "schema")
public class Books implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    
    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Authors author;
    
    @Column(nullable = false)
    private LocalDate yearOfPublication;
    
    @Min(value = 0)
    @Column(nullable = false)
    private Long numberOfPages;
    
    @Min(value = 0)
    @Column(nullable = false)
    private Long price;
    
}
