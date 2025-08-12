package com.example.TaskManager_spring_boot.Entity;


import lombok.Data;

@Data
public class NoteEntity {
    private  int id;
    private String title;
    private String body;

}
