package edu.miu.cse.learn101.service;

import edu.miu.cse.learn101.model.Publisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PublisherService {
    Optional<Publisher> addNewPublisher(Publisher publisher);
    Optional<Publisher> findPublisherByName(String publisherName);
    void deletePublisher(Publisher publisher);
    Optional<Publisher> updatePublisher(Publisher publisher);
}
