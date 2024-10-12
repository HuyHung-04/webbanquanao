package com.example.asmj5.asm.controller;

import com.example.asmj5.asm.entity.KichThuoc;
import com.example.asmj5.asm.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asm")
public class KichThuocController {
    @Autowired
    KichThuocService kichThuocService;
    @GetMapping("/kt-hienthi")
    public String hienThi(Model model){
        model.addAttribute("danhSach",kichThuocService.getAll());
        return "asm/kt-hienthi";
    }

    @GetMapping("/kt-viewadd")
    public String viewAdd(){
        return "asm/kt-viewadd";
    }

    @PostMapping("/kt-add")
    public String add(KichThuoc kichThuoc){
        kichThuocService.add(kichThuoc);
        return "redirect:/asm/kt-hienthi";
    }

    @GetMapping("/kt-delete")
    public String delete(@RequestParam("id") Integer id){
        kichThuocService.delete(id);
        return "redirect:/asm/kt-hienthi";
    }

    @GetMapping("/kt-viewupdate/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model){
        model.addAttribute("kt",kichThuocService.findById(id));
        return "asm/kt-viewupdate";
    }

    @PostMapping("/kt-update")
    public String update(KichThuoc kichThuoc){
        kichThuocService.update(kichThuoc);
        return "redirect:/asm/kt-hienthi";
    }

    @GetMapping("/kt-detail")
    public String dateil(@RequestParam("id") Integer id, Model model){
        model.addAttribute("kt",kichThuocService.findById(id));
        return "asm/kt-detail";
    }
}
