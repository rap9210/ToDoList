package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {

    private ArrayList<toDoListItem> toDoList = new ArrayList<>();
    private ArrayList<toDoListItem> completed;

    @GetMapping ("/toDoForm")
    public String loadBasePage(Model model){
        model.addAttribute("toDoListItem", new toDoListItem());
        return "toDoForm";
    }

    @PostMapping("/list")
    public String confirmItemEntries(@Valid toDoListItem toDoListItem,
                                     BindingResult result, Model model){

        if(result.hasErrors()){
            return "toDoForm";
        }

        toDoList.add(toDoListItem);
        model.addAttribute("toDoList", toDoList);
        return "list";
    }

}
