package com.learnup.project.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Покупатель - ид, имя, фамилия, дата рождения, дата регистрации,
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
    
    @Column(nullable = false)
    private LocalDate dateOfBirth, dateRegistration;
    
    @Column
    private String firstName, lastName;
    
    public Buyers(Long id, LocalDate dateOfBirth, LocalDate dateRegistration, String firstName, String lastName) {
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.dateRegistration = dateRegistration;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
}
