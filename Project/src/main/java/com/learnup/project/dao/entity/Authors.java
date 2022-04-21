package com.learnup.project.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Автор - ФИО, ид
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "schema")
public class Authors implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String fullName;
    
}
