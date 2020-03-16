package org.launchcode.hellopractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Controller lets springboot know this will handle http requests
@Controller
public class HelloController {

    //tells springboot this will return plain text not html
    //getmapping will only accept get requests
    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }
}
