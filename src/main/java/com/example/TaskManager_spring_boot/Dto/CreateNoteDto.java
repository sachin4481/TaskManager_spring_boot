package com.example.TaskManager_spring_boot.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreateNoteDto {
    private String title;
    private String body;
}
