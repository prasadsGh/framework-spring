package com.edigest.myFirstProject.service;

import com.edigest.myFirstProject.entity.JournalEntry;
import com.edigest.myFirstProject.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JournalEntryService {

    //Creating an object to use the crud ops of dependency
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    // business logic to insert the data into the mongo db
    public String saveEntry(JournalEntry journalEntry){
        journalEntry.setDate(new Date());
        journalEntryRepository.save(journalEntry);
        return "Inserted Successfully";
    }

}

//controller --calls-> service --calls--> repository(Interface which extends mongo repo) -->
