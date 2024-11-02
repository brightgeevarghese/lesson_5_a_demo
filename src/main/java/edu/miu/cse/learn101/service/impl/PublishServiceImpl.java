package edu.miu.cse.learn101.service.impl;

import edu.miu.cse.learn101.model.Publisher;
import edu.miu.cse.learn101.repository.PublisherRepository;
import edu.miu.cse.learn101.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublishServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Override
    public Optional<Publisher> addNewPublisher(Publisher publisher) {
        Publisher savedPublisher = publisherRepository.save(publisher);
        return Optional.of(savedPublisher);
    }

    @Override
    public Optional<Publisher> findPublisherByName(String publisherName) {
//        return publisherRepository.findByPublisherName(publisherName);
        return publisherRepository.findPublisherByPublisherName(publisherName);
    }

    @Override
    public void deletePublisher(Publisher publisher) {
        publisherRepository.delete(publisher);
    }

    @Override
    public Optional<Publisher> updatePublisher(Publisher publisher) {
        return Optional.of(publisherRepository.save(publisher));
    }
}
