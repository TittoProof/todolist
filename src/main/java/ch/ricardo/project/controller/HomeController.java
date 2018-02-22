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
import javax.websocket.server.PathParam;

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
        return this.toDoListService.getAllToDoList();
    }
    
    @Timed
    @RequestMapping(path = "/todolist/{id}", method = RequestMethod.GET)
    public ToDoList getList(@PathParam("id") int id) {
        return this.toDoListService.getToDoList(id);
    }
    
    @Timed
    @RequestMapping(path = "/todolist", method = RequestMethod.PUT)
    public ToDoList updateList(@RequestBody ToDoList list) {
        return this.toDoListService.updateList(list);
    }
    
    @Timed
    @RequestMapping(path = "/todolist/{id}", method = RequestMethod.DELETE)
    public void deleteList(@PathParam("id") int id) {
        this.toDoListService.removeToDoList(id);
    }
    
    @Timed
    @RequestMapping(path = "/todolist", method = RequestMethod.POST)
    public ToDoList createList(@RequestBody ToDoList list) {
        return this.toDoListService.createToDoList(list);
    }

}
