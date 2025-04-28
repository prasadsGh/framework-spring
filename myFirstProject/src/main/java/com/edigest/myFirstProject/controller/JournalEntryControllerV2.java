package com.edigest.myFirstProject.controller;

import com.edigest.myFirstProject.entity.JournalEntry;
import com.edigest.myFirstProject.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v2")
public class JournalEntryControllerV2 {

    //Journal Entry Service Object to use
    @Autowired
    private JournalEntryService journalEntryService;

    // get all the posts
    @GetMapping("/get-all")
    public List<JournalEntry> getAll(){
        return null;
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
        return null;
    }

    //get only particular post with
    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return null;
    }
}
