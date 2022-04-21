package com.learnup.project.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Заказ - ид покупателя, ид заказа, сумма покупки
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "schema")
public class Orders implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Min(value = 0)
    @Column(nullable = false)
    private Long purchaseAmount;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Buyers buyer;
    
}
