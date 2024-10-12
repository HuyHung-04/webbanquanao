package com.example.asmj5.asm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/asm")
public class LoginController {
    @GetMapping("/login")
    public String viewLogin(){
        return "asm/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("user") String user, @RequestParam("pass") String pass, Model model){
        if(user.equals("hoang") && pass.equals("123")){
            model.addAttribute("user",user);
            model.addAttribute("pass",pass);
            return "asm/trang-chu";
        }
        else{
            model.addAttribute("error","Thong tin dang nhap sai");
            return "buoi2/login";
        }
    }

    @GetMapping("/trang-chu")
    public String viewTrangChu(){
        return "asm/trang-chu";
    }
}
