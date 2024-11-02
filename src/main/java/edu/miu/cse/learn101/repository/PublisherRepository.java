package edu.miu.cse.learn101.repository;

import edu.miu.cse.learn101.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    Optional<Publisher> findByPublisherName(String publisherName);
    Optional<Publisher> findPublisherByPublisherName(String publisherName);
}
