package com.learnup.project.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Автор - ФИО, ид
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(schema = "schema")
public class Authors implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String fullName;
    
    @JoinColumn
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Fetch(FetchMode.JOIN)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Books> book;
    
    public Authors(Long id, String fullName, Set<Books> book) {
        this.id = id;
        this.fullName = fullName;
        this.book = book;
    }
}
