package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @création 10/06/2023
 * @projet hello
 * @auteur tsyta.diallo
 * @package com.example.hello
 */

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    //@Autowired
    //private Article article;


    @RequestMapping(method = GET, value = "/test")
    public String hello(@RequestParam("name") String name, @RequestParam("age") Integer age){
        return "Hello "+name +" age: "+age;
    }
    @RequestMapping(method = GET, value = "/test2/{name}")
    public String helloV2(@PathVariable("name") String name){
        return "Hello "+name ;
    }
}
