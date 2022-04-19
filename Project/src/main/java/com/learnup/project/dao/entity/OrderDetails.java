package com.learnup.project.dao.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Детали заказа - ид заказа, ид книги, количество, цена
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "order_details", schema = "schema")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Orders order;

    @ManyToOne
    @JoinColumn
    @Fetch(FetchMode.JOIN)
    private Books book;

    @Min(value = 0)
    @Column(nullable = false)
    private Long quantity;

    @Min(value = 0)
    @Column(nullable = false)
    private Long price;
}
