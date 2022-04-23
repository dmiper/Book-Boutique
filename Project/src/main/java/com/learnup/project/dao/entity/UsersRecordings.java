package com.learnup.project.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "schema")
public class UsersRecordings {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    private LocalDate dateRecordings;
    
    @Column
    private Integer idNameUtilities;
    
    @Column
    private Integer idPaymentAndRecording;
    
    @Column
    private Float record;
    
    @ManyToOne
    @JoinColumn
    private Users owner;
    
}
