package com.learnup.project.dao.entity;

import lombok.*;

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
@NoArgsConstructor
@Table(schema = "schema")
public class Orders implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Min(value = 0)
    @Column(nullable = false)
    private Long purchaseAmount;

    @JoinColumn
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Buyers> buyer;


    public Orders(Long id, Long purchaseAmount) {
        this.id = id;
        this.purchaseAmount = purchaseAmount;
    }
}
