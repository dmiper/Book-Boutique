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
 * Детали заказа - ид заказа, ид книги, количество, цена
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
    
    @OneToOne
    private Orders order;
    
    @JoinColumn
    @Fetch(FetchMode.JOIN)
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Books book;
    
    @Min(value = 0)
    @Column(nullable = false)
    private Long quantity, price;
    
}
