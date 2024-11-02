package edu.miu.cse.learn101.service;

import edu.miu.cse.learn101.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BookService {
    Optional<Book> addNewBook(Book book);
    Optional<Book> findBookByISBN(String ISBN);
}
