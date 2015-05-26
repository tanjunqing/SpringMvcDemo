package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tan on 15/5/26.
 */

@Controller
public class HelloWorld {
    @RequestMapping("helloWorld.acs")
    public String helloWorld(){
        System.out.println("HelloWorld");
        return "HelloWorld";
    }
}
