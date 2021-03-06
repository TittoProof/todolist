package com.aegidea.project.service;

import com.aegidea.project.entity.ToDoList;
import com.aegidea.project.repository.ToDoListRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A very basic services for a ToDoList
 * 
 * @author Tiziano (Titto) Fortin <tiz.fortin@gmail.com>
 */
@Service
public class ToDoListService {
    private final static Logger logger = LoggerFactory.getLogger(ToDoListService.class);
    
    @Autowired
    private ToDoListRepository toDoListRepository;
    
    
    /**
     * Create new todolist
     * @param list
     * @return 
     */
    public ToDoList createToDoList(ToDoList list) {
        logger.info("creating new ToDoList");
        return this.toDoListRepository.save(list);
    }
    
    /**
     * Get a list by ID
     * @param id
     * @return 
     */
    public ToDoList getToDoList(int id) {
        logger.info("getting ToDoList with id: {}", id);
        ToDoList list =  this.toDoListRepository.findOne(id);
        return list;
    }
    
    /**
     * Add a Task to a ToDoList both passed as parameter
     * @param list
     * @return 
     */
    public ToDoList updateList(ToDoList list) {
        logger.info("update ToDoList with id: {}", list.getId());
        return this.toDoListRepository.save(list);
    }
    
    /**
     * Remove a ToDOList by ID
     * @param id 
     */
    public void removeToDoList(int id) {
        logger.info("removig ToDoList with id: {}", id);
        this.toDoListRepository.delete(id);
    }
    
    /**
     * Get all the ToDoList stored in database
     * @return 
     */
    public List<ToDoList> getAllToDoList() {
        logger.info("getting all the ToDoList stored");
        List<ToDoList> results = this.toDoListRepository.findAll();
        if(logger.isDebugEnabled())
            logger.debug("the results of getAllList is {}", results.size());
        return results;
    }
    
    /**
     * Get the lists of the user
     * @param user
     * @return 
     */
    public List<ToDoList> getListForUser(String user) {
        logger.info("getting lists for the user: {}", user);
        List<ToDoList> results = this.toDoListRepository.findByOwner(user);
        if(logger.isDebugEnabled())
            logger.debug("the results of getAllList is {}", results.size());
        return results;
    }
}
