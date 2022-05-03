package com.learnup.project.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(schema = "schema")
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Role role;
    
    @Column(nullable = false, unique = true)
    private String loginName, hashPassword;
    
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Buyers buyer;
    
}
