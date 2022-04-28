package com.learnup.project.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Книжный склад - информация об остатках книг по идентификатору книги
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(schema = "schema")
public class BookWarehouse implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Books book;
    
    @Min(value = 0)
    @Column(nullable = false)
    private Long theRestOfTheBooks;
    
    @Version
    private Long version;
    
    public BookWarehouse(Long id, Books book, Long theRestOfTheBooks) {
        this.id = id;
        this.theRestOfTheBooks = theRestOfTheBooks;
        this.book = book;
    }
    
}
