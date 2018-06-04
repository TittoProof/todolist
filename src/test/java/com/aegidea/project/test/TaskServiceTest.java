package com.aegidea.project.test;

import com.aegidea.project.entity.Task;
import com.aegidea.project.entity.ToDoList;
import com.aegidea.project.repository.TaskRepository;
import com.aegidea.project.repository.ToDoListRepository;
import com.aegidea.project.service.TaskService;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Tiziano (Titto) Fortin <tiz.fortin@gmail.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;
    
    @Autowired
    private TaskRepository taskRepository; // here just for test initialization
    
    @Autowired
    private ToDoListRepository toDoListRepository; // here just for test initialization
    
    private Task t1;
    
    private Task t2;
    
    private ToDoList todayList;

    @Before
    public void setupClass() {
        this.todayList = new ToDoList();
        this.toDoListRepository.save(this.todayList);
        // initialize some tasks
        this.t1 = new Task();
        this.t1.setDescription("a very easy task");
        this.t1.setIsComplete(false);
        this.taskRepository.save(this.t1);
        
        this.t2 = new Task();
        this.t2.setDescription("an incredible difficult task");
        this.t2.setIsComplete(true);
        this.taskRepository.save(this.t2);
        
        // initialize also a ToDoList for tests
        
        this.todayList.setName("ToDo Today");
        this.todayList.setOwner("Tiziano");
        List<Task> taskList = new ArrayList<>();
        taskList.add(this.t1);
        taskList.add(this.t2);
        this.todayList.setTasks(taskList);
        this.toDoListRepository.save(this.todayList);
    }

    @After
    public void tearDown() {
        this.toDoListRepository.deleteAll();
    }

    @Test
    public void createTaskTest() {
        Task t3 = new Task();
        t3.setDescription("a new task to finish");
        t3.setIsComplete(false);
        Task stored = this.taskService.createTask(t3);
        assertNotNull(stored);
        assertNotNull(stored.getId());
        assertEquals(t3.getId(), stored.getId());
        assertEquals(t3.getDescription(), stored.getDescription());
    }


    @Test
    public void getTaskTest() {
        Task t4 = this.taskService.getTask(this.t1.getId());
        assertNotNull(t4);
        assertEquals(this.t1.getId(), t4.getId());
        assertEquals(this.t1.getDescription(), t4.getDescription());
        Task notExistingTask = this.taskService.getTask(666);
        assertNull(notExistingTask);
    }

    @Test
    public void updateTaskTest() {
        this.t1.setDescription("task obsolete");
        this.t1.setIsComplete(true);
        Task t5 = this.taskService.updateTask(this.t1);
        assertNotNull(t5);
        assertEquals("task obsolete", t5.getDescription());
        Task t6 = this.taskService.getTask(t5.getId());
        assertNotNull(t6);
        assertEquals(this.t1.getId(), t6.getId());
        assertEquals("task obsolete", t6.getDescription());
        
    }


}
