package com.learnup.project.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "schema")
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_account;
    
    @OneToOne
    private UsersRole role;
    
    @Column(unique = true)
    private String loginName;
    
    @Column(unique = true)
    private String email;
    
    @Column(unique = true)
    private String hashPassword;
    
    @Column
    private String fullName;
    
}
