package ch.ricardo.project.service;

import ch.ricardo.project.entity.Task;
import ch.ricardo.project.entity.ToDoList;
import ch.ricardo.project.repository.TaskRepository;
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
    
    /**
     * Create a new Task 
     * @param task
     * @return 
     */
    public Task createTask(Task task) {
        logger.info("creating new Task: {}", task.toString());
        return this.taskRepository.save(task);
    }
    
    /**
     * Return all the Task for a ToDoList
     * @param list
     * @return 
     */
    public List<Task> getAllTaskForToDoList(ToDoList list) {
        logger.info("getting all tasks for todolist: {}", list.toString());
        return this.taskRepository.findByToDoList(list);
    }
    
    /**
     * Return a specific Task by his ID
     * @param id
     * @return 
     */
    public Task getTask(int id) {
        logger.info("getting task with ID: {}", id);
        return this.taskRepository.findOne(id);
    }
    
    
    /**
     * update a task passed as parameter
     * @param task
     * @return 
     */
    public Task updateTask(Task task) {
        logger.info("update task with ID: {} whit this infos: {}", task.getId(), task.toString());
        return this.taskRepository.save(task);
    }
    
}
