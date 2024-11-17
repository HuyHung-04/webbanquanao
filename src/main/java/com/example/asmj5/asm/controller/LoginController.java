package com.example.asmj5.asm.controller;

import com.example.asmj5.asm.entity.NhanVien;
import com.example.asmj5.asm.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/asm")
public class LoginController {
    @Autowired
    NhanVienService nhanVienService;
    @GetMapping("/login")
    public String viewLogin(){
        return "asm/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("user") String user, @RequestParam("pass") String pass, Model model){
        NhanVien nhanVien = nhanVienService.kiemTraDangNhap(user,pass);
        if(nhanVien != null){
            model.addAttribute("user",nhanVien.getTenDangNhap());
            model.addAttribute("pass",nhanVien.getMatKhau());
            return "asm/trang-chu";
        }
        else{
            model.addAttribute("error","Thông tin đăng nhập sai");
            return "asm/login";
        }
    }

    @GetMapping("/trang-chu")
    public String viewTrangChu(){
        return "asm/trang-chu";
    }
}
