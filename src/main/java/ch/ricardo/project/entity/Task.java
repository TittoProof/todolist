package ch.ricardo.project.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * This is a task need to complete
 * @author Tiziano (Titto) Fortin <tiz.fortin@gmail.com>
 */
@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String description;
    private boolean isComplete;
    
    @ManyToOne
    @JoinColumn(name = "to_do_list_id")
    private ToDoList toDoList;

    public Task() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", description=" + description + ", isComplete=" + isComplete + '}';
    }



    
}
