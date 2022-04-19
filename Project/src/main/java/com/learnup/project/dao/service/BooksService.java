package com.learnup.project.dao.service;

import com.learnup.project.dao.entity.Books;
import com.learnup.project.dao.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public void addBook(Books books) {
        Books book = Books.builder()
                .title(books.getTitle())
                .author(books.getAuthor())
                .yearOfPublication(books.getYearOfPublication())
                .numberOfPages(books.getNumberOfPages())
                .price(books.getPrice())
                .build();
        booksRepository.save(book);
    }

    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }
    public List<Books> getBooksId(Long id) {
        return booksRepository.findBooksByAuthorID(id);
    }

    public void deleteBook(Long id) {
        booksRepository.deleteById(id);
    }

    public void updateBook(Long id, Books books) {
        Books oldBook = booksRepository.getById(id);
        oldBook.setTitle(books.getTitle());
        oldBook.setAuthor(books.getAuthor());
        oldBook.setYearOfPublication(books.getYearOfPublication());
        oldBook.setNumberOfPages(books.getNumberOfPages());
        oldBook.setPrice(books.getPrice());
        booksRepository.save(oldBook);
    }

}
