package com.example.test.controllers;

import com.example.test.entities.Bank;
import com.example.test.entities.Employee;
import com.example.test.services.BankService;
import com.example.test.services.EmployeeService;
import com.example.test.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class BankController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BankService bankService;

    @Autowired
    private PositionService positionService;


    @GetMapping("/banks")
    public String doGetAllBanks(Model model)
    {
        List<Bank> banks=bankService.getAllBanks();
        model.addAttribute("banks",banks);
        return "all_banks";
    }

    @GetMapping("/addBank")
    public String doAddBankGet(Model model)
    {
        Bank bank=new Bank();
        model.addAttribute("bank",bank);
        return "add_bank";
    }

    @PostMapping("/addBank")
    public String doAddBankPost(@ModelAttribute Bank bank)
    {
        bankService.saveBank(bank);
        return "redirect:/banks";
    }




    @GetMapping("/updateBank/{id}")
    public String doUpdateBankGet(@PathVariable Long id,Model model)
    {
        Bank bank=bankService.getBankById(id);
        model.addAttribute("bank",bank);
        return "update_bank";
    }


}
