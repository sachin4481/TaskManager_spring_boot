package com.example.TaskManager_spring_boot.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class Taskentity {
    private int id;
    private String title;
    private String description;
    private Date deadline;
    private boolean compeleted;


}
