package org.launchcode.hellopractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//Controller lets springboot know this will handle http requests
@Controller
public class HelloController {

    //tells springboot this will return plain text not html
    //getmapping will only accept get requests
    //handles requests at path /hello
/*
    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }
*/

    //handles requests at path /goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handles request of the form /hello?name=variable
    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //handles requests of the form /hello/launchcode
    //path parameter
    //@pathvariable tells springboot that this handler method is looking for a request to /hello/name and name can be anything
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body" +
                "<html>";
    }
}
