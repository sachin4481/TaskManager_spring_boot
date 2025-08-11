package com.example.TaskManager_spring_boot.Service;

import com.example.TaskManager_spring_boot.Entity.Taskentity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {
    private ArrayList<Taskentity> tasks=new ArrayList<>();
    private int taskId=1;

    public Taskentity addTask(String title,String descripation,String Deadline)
    {
            Taskentity task=new Taskentity();
            task.setId(taskId);
            task.setTitle(title);
            task.setDescription(descripation);
          //  task.setDeadline(new Date(Deadline));
            task.setCompeleted(false);
            tasks.add(task);
            taskId++;
            return  task;


    }
    public ArrayList<Taskentity> getTasks() {
        return tasks;
    }

   public  Taskentity getTaskById(int id) {
        for(Taskentity task:tasks) {
            if(task.getId()==id)
            {
                return task;
            }
        }
        return  null;


    }
}
