package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller // web controller, methods will handle http requests
//@ResponseBody
//@RequestMapping("hello") /hello/something else   set up route at controller level
public class HelloSpringController {
    // Controller and Routers
    //controller handler methods


    // handler method, get request to route path only localhost:8080
    // set up routes for methods
//    @GetMapping()
//    //@ResponseBody
//    public String routehello() {
//        return "Hello, Spring!";
//    }


    // handles requests at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }


    // handles requests at path /goodbye
//    @GetMapping("goodbye")
//    //@ResponseBody
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }


    // handles requests with query or request parameter, key=name, value=LaunchCode
    // handles requests of the form /hello?name=LaunchCode
    // dynamic request handler (will accept data, use parameter)
    //@GetMapping("hola")   // http://localhost:8080/hola?name=Karen
    // instead of using GetMapping and PostMapping in annotation
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";  // dynamic response
//    }


    // handles requests of the form /hello/LaunchCode
    // path parameter
//    @GetMapping("hello/{name}")     // http://localhost:8080/hello/Java
//    //@ResponseBody
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }


    // handles form requests that deals with post requests
//    @GetMapping("form")
    //@ResponseBody
//    public String helloForm() {   // looks for Thymeleaf template "form"
//        return "<html >" +
//                "<body >" +
//                "<form action='hello' method = 'post' >" + // submit a request to /hello, make a post request
//                "<input type='text' name='name' >" + // single input name, query parameter name, as well
//                "<input type='submit' value='Greet me!' >" +
//                "</form >" +
//                "</body >" +
//                "</html >";
        // Go to Browser Developer Tools, network tab and check for POST request

        // Thymeleaf template that will separate View and Controller
        // template is "view"
//        @GetMapping("form")
//        //@ResponseBody
//        public String helloForm() {   // http://localhost:8080/form then http://localhost:8080/hello?name=Karen
//            return "form";
//    }


    @RequestMapping(value="hello",method = {RequestMethod.GET, RequestMethod.POST})
    //@ResponseBody
    public String hello(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

//    @GetMapping("hello/{name}")
//    //@ResponseBody
//    public String helloAgain(@PathVariable String name, Model model){
//        String greeting = "Hello, " + name + "!";
//        model.addAttribute("greeting", greeting);
//        return "hello";
//    }

    @GetMapping("hello-names")
    @ResponseBody
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
