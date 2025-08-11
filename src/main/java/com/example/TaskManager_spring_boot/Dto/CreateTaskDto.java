package com.example.TaskManager_spring_boot.Dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTaskDto {

    String title;
    String Descriptaion;
    String deadline;
}
