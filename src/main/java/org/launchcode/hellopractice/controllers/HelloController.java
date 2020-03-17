package org.launchcode.hellopractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//Controller lets springboot know this will handle http requests
@Controller
@ResponseBody
@RequestMapping("hello")
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
    // lives at /hello/goodbye because of inherited requestmappping.
    //handles requests at path /goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handles request of the form /hello?name=variable
    //with requestmapping it accepts both Get and Post requests
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //handles requests of the form /hello/launchcode
    //path parameter
    //@pathvariable tells springboot that this handler method is looking for a request to /hello/name and name can be anything
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //lives at /hello/form
    //a form is by default get
    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body" +
                "<html>";
    }
}
