package com.example.TaskManager_spring_boot.Service;

import com.example.TaskManager_spring_boot.Entity.Taskentity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {
    private ArrayList<Taskentity> tasks=new ArrayList<>();
    private int taskId=1;
    private final SimpleDateFormat DeadlineFormate=new SimpleDateFormat("yyyy-MM-dd");

    public Taskentity addTask(String title,String description,String Deadline) throws ParseException {
            Taskentity task=new Taskentity();
            task.setId(taskId);
            task.setTitle(title);
            task.setDescription(description);
            task.setDeadline(DeadlineFormate.parse(Deadline));
            task.setCompleted(false);
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

    public Taskentity updateTask(int id,String Descripation,String Deadline,Boolean Completed) throws ParseException{
        Taskentity task=getTaskById(id);
        if(task==null)
            return null;

        if(Descripation != null)
        {
            task.setDescription(Descripation);
        }
        if(Deadline!=null)
        {
            task.setDeadline(DeadlineFormate.parse(Deadline));

        }
        if(Completed != null ){
                task.setCompleted(Completed);
        }
        return  task;

    }
}
