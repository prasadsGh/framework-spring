package com.edigest.myFirstProject.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "journal_entries")
@Getter
@Setter
@Data
public class JournalEntry {

    @Id
    private String id;
    private String title;
    private String content;

    private Date date;
 }
