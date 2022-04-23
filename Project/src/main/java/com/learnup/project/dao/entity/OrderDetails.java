package com.learnup.project.dao.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Детали заказа - ид заказа, ид книги, количество, цена
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@Table(schema = "schema")
public class OrderDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Orders order;
    
    @JoinColumn
    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Books book;

    @Min(value = 0)
    @Column(nullable = false)
    private Long quantity;

    @Min(value = 0)
    @Column(nullable = false)
    private Long price;
    
    public OrderDetails(Long id, Orders order, Books book, Long quantity, Long price) {
        this.id = id;
        this.order = order;
        this.book = book;
        this.quantity = quantity;
        this.price = price;
    }
}
