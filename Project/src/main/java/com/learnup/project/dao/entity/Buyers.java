package com.learnup.project.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Покупатель - ид, ФИО, дата рождения
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(schema = "schema")
public class Buyers implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JoinColumn
    @Fetch(FetchMode.JOIN)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Users user;
    
    @Column(nullable = false)
    private LocalDate dateOfBirth, dateRegistration;
    
    
    @Fetch(FetchMode.JOIN)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buyer")
    private List<Orders> orders;
    
    @Column
    private String firstName, lastName;
    
}
