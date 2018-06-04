package com.aegidea.project.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * A ToDoList is the task list that contains tasks :) 
 * @author Tiziano (Titto) Fortin <tiz.fortin@gmail.com>
 */
@Entity
public class ToDoList implements Serializable {

    @Id
    @GeneratedValue
    private int Id;
    private String name;
    private String owner;
    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();
    
    public ToDoList() {
        
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "ToDoList{" + "Id=" + Id + ", name=" + name + ", owner=" + owner + ", tasks=" + tasks + '}';
    }
    

}
