package com.gpx.gpxmanager;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public String mainPath(){
        return "Hello World!ee";
    }

}
