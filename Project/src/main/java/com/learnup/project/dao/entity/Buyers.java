package com.learnup.project.dao.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

/**
 * Покупатель - ид, ФИО, дата рождения
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "schema")
public class Buyers implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JoinColumn
    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Users user;
    
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Fetch(FetchMode.JOIN)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "buyer")
    private Collection<Orders> orders;
    
    public Buyers(Long id, Users user, LocalDate dateOfBirth) {
        this.id = id;
        this.user = user;
        this.dateOfBirth = dateOfBirth;
    }
    
    
}
