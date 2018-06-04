package com.aegidea.project.repository;

/**
 *
 * @author Tiziano (Titto) Fortin <tiz.fortin@gmail.com>
 */

import com.aegidea.project.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer>{ 

}