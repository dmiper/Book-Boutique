package com.learnup.project.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyersNoOrdersView {

    private Long id;

    private String fullName;

    private LocalDate dateOfBirth;

}
