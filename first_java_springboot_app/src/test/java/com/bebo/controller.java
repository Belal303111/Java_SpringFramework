package com.bebo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class controller{
    @GetMapping("/staffname")
    public String getstaffdata(Staff model)
    {
        model staff=new model("Belal","Software Engineer",1000000.898);
        model.addAttribute("StaffName",staff);
        return "staffname";
    }
}
