package ch.ricardo.project.controller;

import ch.ricardo.project.entity.ToDoList;
import ch.ricardo.project.exceptions.ToDoListNotFoundException;
import com.codahale.metrics.annotation.Timed;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    private ToDoListService toDoListService;

    /**
     * Get all the ToDoList in the database
     *
     * @return
     */
    @Timed
    @RequestMapping(path = "/todolist/getall", method = RequestMethod.GET)
    public List<ToDoList> getAllList() {
        logger.info("Getting all ToDoList");
        List<ToDoList> results = this.toDoListService.getAllToDoList();
        if (logger.isDebugEnabled()) {
            logger.debug("result size is {}", results.size());
        }
        return results;
    }

    /**
     * Get a ToDoList by ID
     *
     * @param id
     * @return
     */
    @Timed
    @RequestMapping(path = "/todolist/{id}", method = RequestMethod.GET)
    public ToDoList getList(@PathVariable("id") String id) {
        logger.info("Getting specific ToDoList with ID: {}", id);
        ToDoList result = this.toDoListService.getToDoList(Integer.parseInt(id));
        if (result == null) {
            throw new ToDoListNotFoundException("Not found any list with this owner");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("Result : {} ", result.toString());
        }
        return result;
    }

    /**
     * Update an existent ToDOList
     *
     * @param list
     * @return
     */
    @Timed
    @RequestMapping(path = "/todolist", method = RequestMethod.PUT)
    public ToDoList updateList(@RequestBody ToDoList list) {
        logger.info("Update the ToDoList: {}", list.toString());
        return this.toDoListService.updateList(list);
    }

    /**
     * Delete a ToDoList by ID
     *
     * @param id
     */
    @Timed
    @RequestMapping(path = "/todolist/{id}", method = RequestMethod.DELETE)
    public void deleteList(@PathVariable("id") String id) {
        logger.info("Deleting specific ToDoList with ID: {}", id);
        this.toDoListService.removeToDoList(Integer.parseInt(id));
    }

    /**
     * create a new ToDoList
     *
     * @param list
     * @return
     */
    @Timed
    @RequestMapping(path = "/todolist", method = RequestMethod.POST)
    public ToDoList createList(@RequestBody ToDoList list) {
        logger.info("Create new ToDoList: {}", list.toString());
        return this.toDoListService.createToDoList(list);
    }

    /**
     * Get all the ToDoList by the user (owner)
     *
     * @param user
     * @return
     */
    @Timed
    @RequestMapping(path = "/todolist/users/{user}", method = RequestMethod.GET)
    public List<ToDoList> getToDoListByUser(@PathVariable("user") String user) {
        logger.info("Get ToDoLists for user: {}", user);
        return this.toDoListService.getListForUser(user);
    }

}
