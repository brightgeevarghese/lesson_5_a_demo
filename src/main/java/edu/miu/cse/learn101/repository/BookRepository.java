package edu.miu.cse.learn101.repository;

import edu.miu.cse.learn101.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByISBN(String ISBN);
}
