package com.learnup.project.view;

import com.learnup.project.dao.entity.Authors;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BooksView {

    private Long id;

    private String title;

    private Authors author;

    private LocalDate yearOfPublication;

    private Long numberOfPages;

    private Long price;

}
