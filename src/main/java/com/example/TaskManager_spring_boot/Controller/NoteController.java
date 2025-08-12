package com.example.TaskManager_spring_boot.Controller;

import com.example.TaskManager_spring_boot.Dto.CreateNoteDto;
import com.example.TaskManager_spring_boot.Dto.CreateNoteResponseDto;
import com.example.TaskManager_spring_boot.Entity.NoteEntity;
import com.example.TaskManager_spring_boot.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;


    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable int taskId){
        var notes=noteService.getNotesForTask(taskId);
        return ResponseEntity.ok(notes);
    }

   @PostMapping("")
    public ResponseEntity<CreateNoteResponseDto> addNote(@PathVariable int taskId,@RequestBody CreateNoteDto body){
        var note=noteService.addNoteForTask(taskId, body.getTitle(), body.getBody());
        return ResponseEntity.ok(new CreateNoteResponseDto(taskId,note));

   }


}
