package com.bebo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller{
    @GetMapping("/staffname")
    public String getstaffdata()
    {
        return "staffname";
    }
}
