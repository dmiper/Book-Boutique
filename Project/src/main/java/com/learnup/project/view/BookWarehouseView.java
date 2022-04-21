package com.learnup.project.view;

import com.learnup.project.dao.entity.Books;
import lombok.Data;

@Data
public class BookWarehouseView {

    private Long id;

    private Books book;

    private Long theRestOfTheBooks;

    private Long version;
}
