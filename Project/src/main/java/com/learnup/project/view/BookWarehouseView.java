package com.learnup.project.view;

import com.learnup.project.dao.entity.Books;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookWarehouseView {

    private Long id;

    private Books book;

    private Long theRestOfTheBooks;

    private Long version;
}
