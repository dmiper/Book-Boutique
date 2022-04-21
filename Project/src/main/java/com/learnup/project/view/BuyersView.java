package com.learnup.project.view;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BuyersView {

    private Long id;

    private String fullName;

    private LocalDate dateOfBirth;
}
