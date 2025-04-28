package com.edigest.myFirstProject.controller;

import com.edigest.myFirstProject.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    // get all the posts
    @GetMapping("get-all")
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    // create an post and insert it
    @PostMapping("insert-entry")
    public String createEntry(@RequestBody JournalEntry journalEntry){
        journalEntries.put(journalEntry.getId(),journalEntry);

        return "Entry Inserted";
    }

    //change the post
    @PutMapping("change-entry")
    public String changeEntry(@RequestBody JournalEntry journalEntry){
        long id = journalEntry.getId();
        if(!journalEntries.containsKey(id)){
            return "please check id";
        }
        journalEntries.put(id,journalEntry);
        return "entry changed";
    }

    //get only particular post with
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        if(!journalEntries.containsKey(myId)){
            System.out.println("please check id");
            return null;
        }
        return journalEntries.get(myId);
    }
}
