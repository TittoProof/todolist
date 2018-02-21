package ch.ricardo.project.repository;

/**
 *
 * @author Tiziano (Titto) Fortin <tiz.fortin@gmail.com>
 */

import ch.ricardo.project.entity.Task;
import ch.ricardo.project.entity.ToDoList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer>{ 

    public List<Task> findByToDoList(ToDoList list);

}