package com.theelixrlabs.healthcare.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;
@Data
@Document(collection = "patient")
public class Patient {
    @Id
    private String id = UUID.randomUUID().toString();
    private String firstName;
    private String lastName;
    private String aadhaarNumber;
    @DBRef
    private List<Doctor> doctors;
}
