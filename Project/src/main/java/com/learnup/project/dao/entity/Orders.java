package com.learnup.project.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

/**
 * Заказ - ид покупателя, ид заказа, сумма покупки
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(schema = "schema")
public class Orders implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Min(value = 0)
    @Column(nullable = false)
    private Long purchaseAmount;
    
    @JoinColumn
    @Fetch(FetchMode.JOIN)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<OrderDetails> orderDetails;
    
    @JoinColumn
    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Buyers buyers;
    
}
