package org.controller;

import org.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserResource {

    @RequestMapping("{id}")
    public String getUser(@PathVariable("id") int id, Model model){
        User user = new User();
        user.setId(id);
        user.setUserName("ITI");
        model.addAttribute("msg",user.toString());
        return "StaticPage";
    }
}
