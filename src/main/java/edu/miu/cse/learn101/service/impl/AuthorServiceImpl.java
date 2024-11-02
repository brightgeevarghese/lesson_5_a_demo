package edu.miu.cse.learn101.service.impl;

import edu.miu.cse.learn101.model.Author;
import edu.miu.cse.learn101.repository.AuthorRepository;
import edu.miu.cse.learn101.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Optional<Author> addNewAuthor(Author author) {
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName) {
        return authorRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
