package ch.ricardo.project.controller;

import com.codahale.metrics.annotation.Timed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @Timed
    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }
}
