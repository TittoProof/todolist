/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegidea.project.repository;

import com.aegidea.project.entity.ToDoList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Tiziano (Titto) Fortin <tiz.fortin@gmail.com>
 */
public interface ToDoListRepository extends JpaRepository<ToDoList, Integer> { 

    public List<ToDoList> findByOwner(String owner);
    
}
