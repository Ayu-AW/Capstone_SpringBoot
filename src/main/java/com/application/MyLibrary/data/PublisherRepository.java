package com.application.MyLibrary.data;

import com.application.MyLibrary.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
