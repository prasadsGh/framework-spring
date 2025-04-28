package com.edigest.myFirstProject.controller;

import com.edigest.myFirstProject.entity.JournalEntry;
import com.edigest.myFirstProject.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("v2")
public class JournalEntryControllerV2 {

    //Journal Entry Service Object to use
    @Autowired
    private JournalEntryService journalEntryService;

    // get all the posts
    @GetMapping("/get-all")
    public List<JournalEntry> getAll(){
        List<JournalEntry> listOfAllEntries = journalEntryService.getAll();
        return listOfAllEntries;
    }

    // create an post and insert it
    @PostMapping("/insert-entry")
    public String createEntry(@RequestBody JournalEntry journalEntry){
        String message = journalEntryService.saveEntry(journalEntry);
        return message;
    }

    //change the post
    @PutMapping("/change-entry")
    public String changeEntry(@RequestBody JournalEntry journalEntry){
        String response = journalEntryService.changeEntry(journalEntry);
        return response;
    }

    //get only particular post with
    @GetMapping("/id/{myId}")
    public Optional<JournalEntry> getJournalEntryById(@PathVariable String myId){
        Optional<JournalEntry> journalEntry = journalEntryService.getJournalEntryById(myId);
        return journalEntry;

    }

    @DeleteMapping("/id/{myid}")
    public String deleteJournalEntry(@PathVariable("myid") String myId){
        String response = journalEntryService.deleteEntry(myId);
        return response;
    }
}
