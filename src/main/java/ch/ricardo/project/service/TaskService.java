package ch.ricardo.project.service;

import ch.ricardo.project.entity.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tiziano (Titto) Fortin <tiz.fortin@gmail.com>
 */
@Service
public class TaskService {
    private final static Logger logger = LoggerFactory.getLogger(TaskService.class);
    
    
    public Task createTask() {
        return new Task();
    }
    
}
