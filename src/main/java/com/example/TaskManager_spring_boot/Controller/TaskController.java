package com.example.TaskManager_spring_boot.Controller;

import com.example.TaskManager_spring_boot.Entity.Taskentity;
import com.example.TaskManager_spring_boot.Service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.TaskManager_spring_boot.Dto.CreateTaskDto;


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

    @PostMapping
    public ResponseEntity<Taskentity> addTask(@RequestBody CreateTaskDto body) {

         var task=taskService.addTask(body.getTitle(), body.getDescriptaion(), body.getDeadline());
         return  ResponseEntity.ok(task);
    }
}

