/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegidea.project.test;

import com.aegidea.project.entity.ToDoList;
import com.aegidea.project.repository.ToDoListRepository;
import com.jayway.restassured.RestAssured;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
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
public class HomeControllerIT {

    private ToDoList todayList;

    private ToDoList tomorrowList;

    @Autowired
    private ToDoListRepository toDoListRepository; // here just for test initialization

    @Before
    public void setupClass() {
        this.todayList = new ToDoList();
        this.todayList.setName("today");
        this.todayList.setOwner("Tiziano");
        this.toDoListRepository.save(this.todayList);

        this.tomorrowList = new ToDoList();
        this.tomorrowList.setName("tomorrow");
        this.tomorrowList.setOwner("Titto");
        this.toDoListRepository.save(this.tomorrowList);
        assertEquals(2, this.toDoListRepository.findAll().size());
        RestAssured.port = 8080;
    }

    @After
    public void tearDown() {
        this.toDoListRepository.deleteAll();
    }

    @Test
    public void getAllListIT() {
        given().log().all().when().get("/aegidea/todolist/getall").then().assertThat().statusCode(200).body("size()", is(2));
    }
    // non fare l'endpoint che crea un task

    @Test
    public void getListIT() {
        given().log().all().when().pathParam("id", this.todayList.getId()).get("/aegidea/todolist/{id}").then().assertThat().statusCode(200).body("name", equalTo("today"));
        given().log().all().when().pathParam("id", "55").get("/aegidea/todolist/{id}").then().assertThat().statusCode(404);
    }

    @Test
    public void updateListIT() {
        this.todayList.setOwner("new owner");
        given().log().all().when().body(this.todayList).contentType("application/json").put("/aegidea/todolist").then().assertThat().statusCode(200).body("owner", equalTo("new owner"));

    }

    @Test
    public void deleteListIT() {
        given().log().all().when().pathParam("id", this.todayList.getId()).delete("/aegidea/todolist/{id}").then().assertThat().statusCode(200);
    }

    @Test
    public void createListIT() {
        ToDoList newList = new ToDoList();
        newList.setName("ne list");
        newList.setOwner("me");
        given().log().all().when().body(newList).contentType("application/json").post("/aegidea/todolist").then().assertThat().statusCode(200).body("owner", equalTo("me"));
    }
    
    @Test
    public void getByUserIT() {
        given().log().all().when().pathParam("user", "Tiziano").get("/aegidea/todolist/users/{user}").then().assertThat().statusCode(200).body("size()", is(1));
        given().log().all().when().pathParam("user", "Titto").get("/aegidea/todolist/users/{user}").then().assertThat().statusCode(200).body("size()", is(1));
        given().log().all().when().pathParam("user", "fake").get("/aegidea/todolist/users/{user}").then().assertThat().statusCode(200).body("size()", is(0));
    }

}
