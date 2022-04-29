package com.learnup.project.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Автор - ФИО, ид
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(schema = "schema")
public class Authors implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String fullName;
    
    @Fetch(FetchMode.JOIN)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Books> book;
    
    public Authors(Long id, String fullName, List<Books> book) {
        this.id = id;
        this.fullName = fullName;
        this.book = book;
    }
}
