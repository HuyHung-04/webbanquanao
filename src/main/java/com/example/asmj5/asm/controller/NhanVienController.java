package com.example.asmj5.asm.controller;

import com.example.asmj5.asm.entity.NhanVien;
import com.example.asmj5.asm.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asm")
public class NhanVienController {
   @Autowired
   NhanVienService nhanVienService;
    @GetMapping("/nv-hienthi")
    public String hienThi(Model model){
        model.addAttribute("danhSach",nhanVienService.getAll());
        return "asm/nv-hienthi";
    }

    @GetMapping("/nv-viewadd")
    public String viewAdd(){
        return "asm/nv-viewadd";
    }

    @PostMapping("/nv-add")
    public String add(NhanVien nhanVien){
        nhanVienService.add(nhanVien);
        return "redirect:/asm/nv-hienthi";
    }

    @GetMapping("/nv-delete")
    public String delete(@RequestParam("id") Integer id){
        nhanVienService.delete(id);
        return "redirect:/asm/nv-hienthi";
    }

    @GetMapping("/nv-detail")
    public String detail(@RequestParam("id") Integer id, Model model){
        model.addAttribute("nv",nhanVienService.findById(id));
        return "asm/nv-detail";
    }

    @GetMapping("/nv-viewupdate/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model){
        model.addAttribute("nv",nhanVienService.findById(id));
        return "asm/nv-viewupdate";
    }

    @PostMapping("/nv-update")
    public String update(NhanVien nhanVien){
        nhanVienService.update(nhanVien);
        return "redirect:/asm/nv-hienthi";
    }
}
