package com.edigest.myFirstProject.service;

import com.edigest.myFirstProject.entity.JournalEntry;
import com.edigest.myFirstProject.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    //Creating an object to use the crud ops of dependency
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    // save entry
    public String saveEntry(JournalEntry journalEntry){
        journalEntry.setDate(new Date());
        journalEntryRepository.save(journalEntry);
        return "Inserted Successfully";
    }

    // get all entry
    public List<JournalEntry> getAll(){
        List<JournalEntry> listOfAllEntries = journalEntryRepository.findAll();
        return listOfAllEntries;
    }

    // get one by Id
    public Optional<JournalEntry> getJournalEntryById(String id){
        Optional<JournalEntry> journalEntry = journalEntryRepository.findById(id);
        return journalEntry;
    }

    //make changes into existing id
    public String changeEntry(JournalEntry journalEntry){
        Optional<JournalEntry> existingJournalEntry = journalEntryRepository.findById(journalEntry.getId());
        if(existingJournalEntry.isEmpty()){
            return "please re-check id";
        }
        journalEntryRepository.deleteById(journalEntry.getId());
        journalEntryRepository.save(journalEntry);

        return "changes applied successfully";
    }

    //delete entry by id
    public String deleteEntry(String id){
        Optional<JournalEntry> journalEntryOptional = journalEntryRepository.findById(id);
        if(journalEntryOptional.isEmpty()){
            return "please re-check id";
        }
        JournalEntry journalEntry = journalEntryOptional.get();
        journalEntryRepository.delete(journalEntry);
        return "deleted";
    }

}

//controller --calls-> service --calls--> repository(Interface which extends mongo repo) -->
