package com.example.TaskManager_spring_boot.Dto;

import com.example.TaskManager_spring_boot.Entity.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateNoteResponseDto {
    private Integer taskId;
    private NoteEntity note;
}
