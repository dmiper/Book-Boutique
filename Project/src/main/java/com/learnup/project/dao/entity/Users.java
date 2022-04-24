package com.learnup.project.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "schema")
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    private UsersRole role;
    
    @Column(unique = true)
    private String loginName, email, hashPassword;
    
    @Column
    private String firstName, lastName;
    
    @Column
    private LocalDate dateRegistration;
    
}
