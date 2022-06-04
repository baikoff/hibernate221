package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FirstScreenController {

    @GetMapping(value = "/")
    public String hello(ModelMap model){
        List<String> message = new ArrayList<>();
        message.add("Privet");
        message.add("CRUD prilojenie");
        model.addAttribute("message", message);
        return "index";
    }
}
