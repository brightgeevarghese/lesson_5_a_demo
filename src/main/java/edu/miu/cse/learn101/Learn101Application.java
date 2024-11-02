package edu.miu.cse.learn101;

import edu.miu.cse.learn101.model.Address;
import edu.miu.cse.learn101.model.Author;
import edu.miu.cse.learn101.model.Book;
import edu.miu.cse.learn101.model.Publisher;
import edu.miu.cse.learn101.service.AuthorService;
import edu.miu.cse.learn101.service.BookService;
import edu.miu.cse.learn101.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class Learn101Application {

    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(Learn101Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Address address = new Address("2000 N St", "Fairfield", "IA", 52556);
            Publisher publisher = new Publisher();
            publisher.setPublisherName("Apres");
            publisher.setPrimaryAddress(address);
            System.out.println(publisherService.addNewPublisher(publisher) + " is saved");
            Publisher foundPublisher = publisherService.findPublisherByName("Apres").orElseThrow();
            System.out.println("Found: " + foundPublisher);
//            publisherService.deletePublisher(foundPublisher);

//            publisherService.findPublisherByName("Apres")
//                    .ifPresent(
//                            publisher1 -> {
//                                System.out.println(publisher1 + " is found");
//                                publisher1.setPublisherName("Apres2");
//                                publisherService.updatePublisher(publisher1);
//                            }
//                    );
            List<Author> authors = List.of(
                new Author("Bright", "Varghese"),
                new Author("John", "Jim"),
                new Author("Tom", "Jerry")
            );
            //Save Authors
            for (Author author : authors) {
                authorService.addNewAuthor(author);
            }
            //Create books
            Book book1 = new Book("Java", "1234");
            Book book2 = new Book("Kotlin", "5678");
            book1.setPublisher(publisherService.findPublisherByName("Apres").get());
            book2.setPublisher(publisherService.findPublisherByName("Apres").get());
            book1.setAuthors(authors);
            book2.setAuthors(authors);
            bookService.addNewBook(book1);
            bookService.addNewBook(book2);
            bookService.findBookByISBN("1234").ifPresent(System.out::println);
        };
    }
}
