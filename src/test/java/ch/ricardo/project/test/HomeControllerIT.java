/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ricardo.project.test;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 *
 * @author Tiziano (Titto) Fortin <tiz.fortin@gmail.com>
 */
public class HomeControllerIT {

    @Test
    public void firstEchoTest() {
//        get("/echo/hello").then().assertThat().body("message", equalTo("hello"));
    }
}
