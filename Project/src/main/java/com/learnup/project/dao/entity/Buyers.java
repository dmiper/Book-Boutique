package com.learnup.project.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Покупатель - ид, ФИО, дата рождения
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "buyers", schema = "schema")
public class Buyers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;
}
