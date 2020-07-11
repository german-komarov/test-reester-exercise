package com.example.test.controllers;


import com.example.test.entities.Bank;
import com.example.test.entities.Employee;
import com.example.test.entities.Position;
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
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BankService bankService;

    @Autowired
    private PositionService positionService;


    @GetMapping("/employees")
    public String doGetAllEmployees(Model model)
    {
        List<Employee> employees=employeeService.getAllEmployees();
        model.addAttribute("employees",employees);
        return "all_employees";
    }

    @GetMapping("/addEmployee")
    public String doAddEmployeeGet(Model model)
    {
        Employee employee=new Employee();
        employee.setArchived(false);
        model.addAttribute("employee",employee);
        return "add_employee";
    }

    @PostMapping("/addEmployee")
    public String doAddEmployeePost(@ModelAttribute Employee employee, @RequestParam String bankName,@RequestParam String positionName)
    {
        employeeService.saveNewEmployee(employee,bankName,positionName);
        return "redirect:/employees";
    }

    @GetMapping("/archiveEmployee/{id}")
    public String doArchiveEmployee(@PathVariable Long id)
    {
        Employee employee=employeeService.getEmployeeById(id);
        employee.setArchived(true);
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/unarchiveEmployee/{id}")
    public String doUnarchiveEmployee(@PathVariable Long id)
    {
        Employee employee=employeeService.getEmployeeById(id);
        employee.setArchived(false);
        employeeService.saveEmployee(employee);
        return "redirect:/archive";
    }

    @GetMapping("/archive")
    public String doGetArchive(Model model)
    {
        List<Employee> employees=employeeService.getAllEmployees();
        model.addAttribute("employees",employees);
        return "employees_archive";
    }


    @GetMapping("/updateEmployee/{id}")
    public String doUpdateEmployeeGet(@PathVariable Long id,Model model)
    {
        Employee employee=employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        model.addAttribute("bankName",employee.getBankOrganization().getName());
        model.addAttribute("positionName",employee.getPosition().getName());
        return "update_employee";
    }



}
