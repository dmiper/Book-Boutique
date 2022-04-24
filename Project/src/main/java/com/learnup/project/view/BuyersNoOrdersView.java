package com.learnup.project.view;

import com.learnup.project.dao.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyersNoOrdersView {

    private Long id;

    private Users user;

    private LocalDate dateOfBirth;

}
