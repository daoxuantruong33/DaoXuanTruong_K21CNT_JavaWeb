package com.k21cnt.dxt.lesson11.controller;
import com.k21cnt.dxt.lesson11.dto.Dxt_accountDTO;
import com.k21cnt.dxt.lesson11.entity.Dxt_account;
import com.k21cnt.dxt.lesson11.service.Dxt_accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/dxt_accounts")
public class Dxt_accountController {
    @Autowired
    private Dxt_accountService dxt_accountService;
    public Dxt_accountController(Dxt_accountService dxt_accountService){
        this.dxt_accountService = dxt_accountService;
    }
    @GetMapping
    public String getDxt_accounts (Model model){
        model.addAttribute("dxt_accounts", dxt_accountService.fillAll());
        return "dxt_accounts/dxt_accounts-list";
    }
    @GetMapping("/add-new")
    public String addNewDxt_account (Model model){
        model.addAttribute("dxt_accounts", new Dxt_account());
        return "dxt_accounts/dxt_accounts-add";
    }
    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model){
        Dxt_accountDTO employee = dxt_accountService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));

        model.addAttribute("dxt_accounts", employee);
        return "dxt_accounts/dxt_accounts-edit";
    }
    @PostMapping
    public String saveDxt_account (@ModelAttribute("dxt_accounts") Dxt_accountDTO dxtAccount){
        dxt_accountService.save(dxtAccount);
        return "redirect:/dxt_accounts";
    }
    @PostMapping ("/update/{id}")
    public String updateDxt_account (@PathVariable(value = "id") Long id, @ModelAttribute("employee") Dxt_accountDTO dxtAccount){
        dxt_accountService.updatedDxt_accountById(id,dxtAccount);
        return "redirect:/dxt_accounts";
    }
    @GetMapping("/delete/{id}")
    public String deleteDxt_account (@PathVariable(value = "id") Long id){
        dxt_accountService.deleteDxt_account(id);
        return "redirect:/dxt_accounts";
    }
}
