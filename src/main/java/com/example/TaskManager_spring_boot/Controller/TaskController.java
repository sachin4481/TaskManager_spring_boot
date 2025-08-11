package com.example.TaskManager_spring_boot.Controller;

import com.example.TaskManager_spring_boot.Dto.ErrorHandleDto;
import com.example.TaskManager_spring_boot.Dto.UpadateTaskDto;
import com.example.TaskManager_spring_boot.Entity.Taskentity;
import com.example.TaskManager_spring_boot.Service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.TaskManager_spring_boot.Dto.CreateTaskDto;


import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService=taskService;
    }


    @GetMapping("")
    public ResponseEntity< List<Taskentity>> getTask() {
            var tasks=taskService.getTasks();

            return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taskentity> getTaskById(@PathVariable int id)
    {
        var task=taskService.getTaskById(id);
        if(task==null)
        {
          return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(task);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Taskentity> updateTask(@PathVariable int id, @RequestBody UpadateTaskDto u) throws ParseException {

        var task=taskService.updateTask(id, u.getDescription(),u.getDeadline(),u.getCompleted());
        if(task==null)
        {
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);

    }

    @PostMapping
    public ResponseEntity<Taskentity> addTask(@RequestBody CreateTaskDto body) throws ParseException {

         var task=taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());
         return  ResponseEntity.ok(task);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorHandleDto> handlesErrors(Exception e){
            if(e instanceof ParseException){
                return ResponseEntity.badRequest().body(new ErrorHandleDto("invalid data formate"));
            }

            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ErrorHandleDto("internal server Error"));


    }

}

