package org.launchcode.hellopractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//Controller lets springboot know this will handle http requests
@Controller
public class HelloController {

    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //responds to /hello/Launchcode
    @RequestMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }
}
