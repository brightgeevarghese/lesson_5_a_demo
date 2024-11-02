package edu.miu.cse.learn101.service.impl;

import edu.miu.cse.learn101.model.Book;
import edu.miu.cse.learn101.repository.BookRepository;
import edu.miu.cse.learn101.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Optional<Book> addNewBook(Book book) {
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> findBookByISBN(String ISBN) {
        return bookRepository.findByISBN(ISBN);
    }
}
