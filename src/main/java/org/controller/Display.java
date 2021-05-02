package org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Display {

    @RequestMapping("header")
    public String displayHeader(@RequestHeader("Host") String cookie, Model model){
        model.addAttribute("msg", "Host is "+ cookie);
        return "StaticPage";
    }

    @RequestMapping("cookie")
    public String displayCookie(@CookieValue("JSESSIONID") String cookie, Model model){
        model.addAttribute("msg", "Cookie is "+ cookie);
        return "StaticPage";
    }
}
