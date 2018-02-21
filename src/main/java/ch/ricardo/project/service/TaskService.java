package ch.ricardo.project.service;

import ch.ricardo.project.entity.Task;
import ch.ricardo.project.repository.TaskRepository;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tiziano (Titto) Fortin <tiz.fortin@gmail.com>
 */
@Service
public class TaskService {
    private final static Logger logger = LoggerFactory.getLogger(TaskService.class);
    
    @Autowired
    private TaskRepository taskRepository;
    
    
    public Task createTask() {
        return new Task();
    }
    
    public List<Task> getAllTask() {
        return new ArrayList();
    }
    
    public Task getTask(int id) {
        return new Task();
    }
    
    public void deleteTask(int id) {
        
    }
    
    public Task updateTask(Task task) {
        return new Task();
    }
    
}
