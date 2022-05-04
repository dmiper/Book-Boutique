package com.learnup.project.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Детали заказа - ид деталей заказа, ид заказа, ид книги, количество, цена
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(schema = "schema")
public class OrderDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JoinColumn
    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Books book;
    
    @Min(value = 0)
    @Column(nullable = false)
    private Long quantity, price;
    
    public OrderDetails(Long id) {
        this.id = id;
    }
    
    public OrderDetails(Long quantity, Long price) {
        this.price = price;
        this.quantity = quantity;
    }
}
