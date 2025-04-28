package com.edigest.myFirstProject.repository;

import com.edigest.myFirstProject.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface JournalEntryRepository extends MongoRepository<JournalEntry,String> {


}
