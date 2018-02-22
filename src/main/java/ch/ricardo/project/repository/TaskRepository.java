package ch.ricardo.project.repository;

/**
 *
 * @author Tiziano (Titto) Fortin <tiz.fortin@gmail.com>
 */

import ch.ricardo.project.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer>{ 

}