package com.example.asmj5.asm.controller;

import com.example.asmj5.asm.entity.KhachHang;
import com.example.asmj5.asm.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asm")
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;
    @GetMapping("/kh-hienthi")
    public String hienThi(Model model){
        model.addAttribute("danhSach",khachHangService.getAll());
        return "asm/kh-hienthi";
    }

    @GetMapping("/kh-viewadd")
    public String viewAdd(){
        return "asm/kh-viewadd";
    }

    @PostMapping("/kh-add")
    public String add(KhachHang khachHang){
        khachHangService.add(khachHang);
        return "redirect:/asm/kh-hienthi";
    }

    @GetMapping("/kh-delete")
    public String delete(@RequestParam("id") Integer id){
        khachHangService.delete(id);
        return "redirect:/asm/kh-hienthi";
    }

    @GetMapping("/kh-viewupdate/{id}")
    public String viewupdate(@PathVariable("id") Integer id, Model model){
        model.addAttribute("kh",khachHangService.findById(id));
        return "asm/kh-viewupdate";
    }

    @PostMapping("/kh-update")
    public String update(KhachHang khachHang){
        khachHangService.update(khachHang);
        return "redirect:/asm/kh-hienthi";
    }

    @GetMapping("/kh-detail")
    public String detail(@RequestParam("id") Integer id, Model model){
        model.addAttribute("kh",khachHangService.findById(id));
        return "asm/kh-detail";
    }
}
