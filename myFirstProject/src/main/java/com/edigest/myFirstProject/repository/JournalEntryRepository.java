package com.edigest.myFirstProject.repository;

import com.edigest.myFirstProject.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry,String> {

}
