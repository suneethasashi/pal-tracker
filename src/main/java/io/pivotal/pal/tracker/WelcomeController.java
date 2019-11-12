package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


    private String helloConstant;

    @GetMapping("/")
    public String sayHello() {
        return helloConstant;
    }


    public WelcomeController( @Value("${welcome.message}") String message) {
        this.helloConstant = message;
    }
}
