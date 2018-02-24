package ch.ricardo.project.controller;

import ch.ricardo.project.entity.ToDoList;
import com.codahale.metrics.annotation.Timed;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ch.ricardo.project.service.TaskService;
import ch.ricardo.project.service.ToDoListService;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Just a simple rest controller for spring
 *
 * @author Tiziano (Titto) Fortin <tiz.fortin@gmail.com>
 */
@RestController
@RequestMapping("/ricardo")
public class HomeController {

    private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private TaskService taskService;
    
    @Autowired
    private ToDoListService toDoListService;

    @Timed
    @RequestMapping(path = "/todolist/getall", method = RequestMethod.GET)
    public List<ToDoList> getAllList() {
        List<ToDoList> results = this.toDoListService.getAllToDoList();
        if(logger.isDebugEnabled())
            logger.debug("result size is {}", results.size());
        return results;
    }
    
    @Timed
    @RequestMapping(path = "/todolist/{id}", method = RequestMethod.GET)
    public ToDoList getList(@PathVariable("id") String id) {
        if(logger.isDebugEnabled())
            logger.debug("Getting specific ToDoList with ID: {}", id);
        return this.toDoListService.getToDoList(Integer.parseInt(id));
    }
    
    @Timed
    @RequestMapping(path = "/todolist", method = RequestMethod.PUT)
    public ToDoList updateList(@RequestBody ToDoList list) {
        return this.toDoListService.updateList(list);
    }
    
    @Timed
    @RequestMapping(path = "/todolist/{id}", method = RequestMethod.DELETE)
    public void deleteList(@PathVariable("id") String id) {
        if(logger.isDebugEnabled())
            logger.debug("Deleting specific ToDoList with ID: {}", id);
        this.toDoListService.removeToDoList(Integer.parseInt(id));
    }
    
    @Timed
    @RequestMapping(path = "/todolist", method = RequestMethod.POST)
    public ToDoList createList(@RequestBody ToDoList list) {
        return this.toDoListService.createToDoList(list);
    }
    
   @Timed
   @RequestMapping(path = "/todolist/users/{user}", method = RequestMethod.GET)
   public List<ToDoList> getToDoListByUser(@PathVariable("user") String user) {
       return this.toDoListService.getListForUser(user);
   }

}
