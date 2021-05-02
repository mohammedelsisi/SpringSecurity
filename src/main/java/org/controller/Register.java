package org.controller;

import org.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.*;

@Controller
public class Register {

    @RequestMapping(value = "/signup")
    public String createNewUser(Model model, HttpSession session) {
        session.setAttribute("user","user");
        model.addAttribute("newUser", new User());
        return "Registration";
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("newUser") User user,
                           BindingResult bindingResult,
                           Model model)
    {

        if (bindingResult.hasErrors()) {
            return "Registration";
        }
        model.addAttribute("msg", "Hello " + user.getUserName());
        return "StaticPage";
    }


}
