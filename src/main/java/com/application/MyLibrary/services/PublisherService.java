package com.application.MyLibrary.services;

import com.application.MyLibrary.data.PublisherRepository;
import com.application.MyLibrary.models.Author;
import com.application.MyLibrary.models.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    // Method to fetch list of all publishers
    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    // Method to fetch a specific publisher by id
    public Publisher findPublisherById(Long id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found!"));
        return publisher;
    }

    // Method to add/create a new publisher
    public void createPublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    // Method to update a publisher given the publisher object
    public void updatePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    //Method to delete publisher
    public void deletePublisher(Long id) {
        //Find the publisher
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found!"));
        publisherRepository.deleteById(publisher.getId());
    }

}
