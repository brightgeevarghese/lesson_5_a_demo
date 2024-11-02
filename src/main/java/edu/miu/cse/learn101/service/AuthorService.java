package edu.miu.cse.learn101.service;

import edu.miu.cse.learn101.model.Author;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> addNewAuthor(Author author);
    Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);
}
