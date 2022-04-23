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
public class UsersRole {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_account;
    
    @Column
    private String role;
    
}
