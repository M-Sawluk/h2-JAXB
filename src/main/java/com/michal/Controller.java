package com.michal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mike on 2017-07-01.
 */
@RestController
public class Controller {

    @RequestMapping("/")
    public String index(){
        return "Helo";
    }
}
