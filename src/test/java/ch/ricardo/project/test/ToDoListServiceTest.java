package ch.ricardo.project.test;

import ch.ricardo.project.entity.Task;
import ch.ricardo.project.entity.ToDoList;
import ch.ricardo.project.repository.TaskRepository;
import ch.ricardo.project.repository.ToDoListRepository;
import ch.ricardo.project.service.ToDoListService;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
public class ToDoListServiceTest {

    @Autowired
    private ToDoListRepository toDoListRepository; // here just for test initialization

    @Autowired
    private TaskRepository taskRepository; // here just for test initialization
    
    @Autowired
    private ToDoListService toDoListService; // the real class need to test

    private Task t1;

    private Task t2;

    private ToDoList todayList;

    @Before
    public void setupClass() {
        // initialize an empty ToDoList
        
        this.todayList = new ToDoList();
        this.todayList.setName("ToDo Tomorrow");
        this.todayList.setOwner("Tiziano");
        this.toDoListRepository.save(this.todayList);
        // initialize some tasks but not stored
        this.t1 = new Task();
        this.t1.setDescription("a very easy task");
        this.t1.setIsComplete(false);

        this.t2 = new Task();
        this.t2.setDescription("an incredible difficult task");
        this.t2.setIsComplete(true);
    }

    @After
    public void tearDown() {
        this.toDoListRepository.deleteAll();
    }
    
    @Test
    public void createToDoListTest() {
        assertEquals(1, this.toDoListRepository.findAll().size()); // ensure there is only 1 list stored
        // create a empty and basic toDoList
        ToDoList myList = new ToDoList();
        myList.setName("Task for the kitchen");
        myList.setOwner("Titto");
        this.toDoListService.createToDoList(myList);
        assertEquals(2, this.toDoListRepository.findAll().size());
    }
    
    @Test
    public void getToDoListTest() {
        ToDoList retrieved = this.toDoListService.getToDoList(this.todayList.getId());
        assertNotNull(retrieved);
        assertEquals(this.todayList.getId(), retrieved.getId());
        assertEquals(this.todayList.getName(), retrieved.getName());
    }
    
    @Test
    public void updateListTest() {
        this.todayList.getTasks().add(this.t1);
        this.toDoListService.updateList(this.todayList);
        ToDoList myList = this.toDoListRepository.findOne(this.todayList.getId());
        assertNotNull(myList);
        assertNotNull(myList.getTasks());
        assertEquals(1, myList.getTasks().size());
        assertNotNull(this.taskRepository.findAll()); 
    }
    
    @Test
    public void removeToDoListTest() {
        assertEquals(1, this.toDoListRepository.findAll().size());
        this.toDoListRepository.delete(this.todayList.getId());
        assertEquals(0, this.toDoListRepository.findAll().size());
    }
    
    @Test
    public void getAllToDoListTest() {
        assertEquals(1, this.toDoListService.getAllToDoList().size());
        this.toDoListRepository.save(new ToDoList());
        assertEquals(2, this.toDoListService.getAllToDoList().size());
    }
    
    @Test
    public void getAllByUserTest() {
        assertEquals(1, this.toDoListService.getListForUser("Tiziano").size());
        assertEquals(0, this.toDoListService.getListForUser("fake user").size());
    } 

}
