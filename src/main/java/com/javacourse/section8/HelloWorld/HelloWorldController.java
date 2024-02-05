package com.javacourse.section8.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping(value = "/helloworld")
    public String showHelloWorldPage(){

        return "Hello world!";
    }
    @GetMapping(value = "/helloworld-bean")
    public HelloWorldBean helloWorldBean(){

        return new HelloWorldBean("Hello world!");
    }
    @GetMapping(value = "/helloworld-pathvariable/{name}")
        public String showHelloWorldPageWithPathVariable(@PathVariable String name){
                return "Hello world " + name;
        }

}
