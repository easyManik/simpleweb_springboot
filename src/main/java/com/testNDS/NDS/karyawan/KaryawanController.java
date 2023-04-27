package com.testNDS.NDS.karyawan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class KaryawanController {
    @Autowired private KaryawanService service;

    @GetMapping("/karyawan")
    public String browserList(Model model){
        List<Karyawan> karyawanList = service.listAll();
        model.addAttribute("karyawanList", karyawanList);

        return "karyawan";
    }

    @GetMapping("/karyawan/add")
    public String showAddForm(Model model){
        model.addAttribute("karyawan", new Karyawan());
        return "add_form";
    }

    @RequestMapping(value = "/karyawan/save", method = RequestMethod.POST)
    public String saveAddForm(Karyawan karyawan, RedirectAttributes ra){
        service.save(karyawan);
        ra.addFlashAttribute("message", "Berhasil menambahkan karyawan baru");
        return "redirect:/karyawan";
    }

    @GetMapping("/karyawan/edit/{kode}")
    public String showEditForm(@PathVariable("kode") Long kode, Model model, RedirectAttributes ra){
        try{
            Karyawan karyawan = service.get(kode);
            model.addAttribute("karyawan", karyawan);
            model.addAttribute("pageTitle", "Edit Karyawan (kode: " + kode + ")");
            return "add_form";
        } catch (NotFoundException e) {
            throw new RuntimeException(e);

        }
    }

    @GetMapping("/karyawan/delete/{kode}")
    public String deleteUser(@PathVariable("kode") Long kode, RedirectAttributes ra) {
        service.delete(kode);
        ra.addFlashAttribute("message", "The Karyawan Code " + kode + " has been deleted.");
        return "redirect:/karyawan";
    }

    @RequestMapping(path = {  "/karyawan/search"})
    public String search(Karyawan karyawan, Model model, String keyword, LocalDateTime startDate, LocalDateTime endDate){
        if(keyword!=null){
            List<Karyawan> list = service.getByKeyword(keyword, startDate, endDate);
            model.addAttribute("karyawanList", list);
        }else {
            List<Karyawan> list = service.getAll();
            model.addAttribute("karyawanList", list);
        }
        return "karyawan";
    }
}

