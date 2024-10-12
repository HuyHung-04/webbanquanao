package com.example.asmj5.asm.controller;

import com.example.asmj5.asm.entity.MauSac;
import com.example.asmj5.asm.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asm")
public class MauSacController {
    @Autowired
    MauSacService mauSacService;
    @GetMapping("/ms-hienthi")
    public String hienThi(Model model){
        model.addAttribute("danhSach",mauSacService.getAll());
        return "asm/ms-hienthi";
    }

    @GetMapping("/ms-viewadd")
    public String viewAdd(){
        return "asm/ms-viewadd";
    }

    @PostMapping("/ms-add")
    public String add(MauSac mauSac){
        mauSacService.add(mauSac);
        return "redirect:/asm/ms-hienthi";
    }

    @GetMapping("/ms-delete")
    public String delete(@RequestParam("id") Integer id){
        mauSacService.delete(id);
        return "redirect:/asm/ms-hienthi";
    }

    @GetMapping("/ms-detail")
    public String detail(@RequestParam("id") Integer id, Model model){
        model.addAttribute("ms",mauSacService.findById(id));
        return "asm/ms-detail";
    }

    @GetMapping("/ms-viewupdate/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model){
        model.addAttribute("ms",mauSacService.findById(id));
        return "asm/ms-viewupdate";
    }

    @PostMapping("/ms-update")
    public String update(MauSac mauSac){
        mauSacService.update(mauSac);
        return "redirect:/asm/ms-hienthi";
    }
}
