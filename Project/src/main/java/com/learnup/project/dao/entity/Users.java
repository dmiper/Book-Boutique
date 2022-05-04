package com.learnup.project.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;

/**
 * Пользователь - ид, ид роли, логин, пароль, емейл, пользователь
 */
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
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Role role;
    
    @Column(nullable = false, unique = true)
    private String loginName;
    
    @Column(nullable = false)
    private String hashPassword;
    
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Buyers buyer;
    
}
