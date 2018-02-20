package ch.ricardo.project.controller;

import ch.ricardo.project.entity.Task;
import ch.ricardo.project.repository.UserRepository;
import com.codahale.metrics.annotation.Timed;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Just a simple rest controller for spring
 *
 * @author Tiziano (Titto) Fortin <tiz.fortin@gmail.com>
 */
@RestController
public class HomeController {

    private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserRepository userRepository;
    @Value("${env}")
    private String env;

    @Timed
    @RequestMapping(path = "/users/", method = RequestMethod.GET)
    public List<Task> getUsers() {
        return userRepository.findAll(); // returning all persisted users
    }
    @Timed
    @RequestMapping(path = "/users/", method = RequestMethod.POST)
    public Task saveUser(@RequestBody Task user) {
        userRepository.save(user); // using it to persist
        return user;
    }

}
