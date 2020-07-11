package com.example.test.controllers;

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

@Controller
public class PositionController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BankService bankService;

    @Autowired
    private PositionService positionService;


    @GetMapping("/positions")
    public String doGetAllPositions(Model model)
    {
        List<Position> positions=positionService.getAllPositions();
        model.addAttribute("positions",positions);
        return "all_positions";
    }

    @GetMapping("/addPosition")
    public String doAddPositionGet(Model model)
    {
        Position position=new Position();
        position.setArchived(false);
        model.addAttribute("position",position);
        return "add_position";
    }

    @PostMapping("/addPosition")
    public String doAddPositionPost(@ModelAttribute Position position)
    {
        positionService.savePosition(position);
        return "redirect:/positions";
    }

    @GetMapping("/archivePosition/{id}")
    public String doArchivePosition(@PathVariable Long id)
    {
        Position position=positionService.getPositionById(id);
        position.setArchived(true);
        positionService.savePosition(position);
        return "redirect:/positions";
    }

    @GetMapping("/unarchivePosition/{id}")
    public String doUnarchivePosition(@PathVariable Long id)
    {
        Position position=positionService.getPositionById(id);
        position.setArchived(false);
        positionService.savePosition(position);
        return "redirect:/archiveOfPositions";
    }

    @GetMapping("/archiveOfPositions")
    public String doGetArchivePosition(Model model)
    {
        List<Position> positions=positionService.getAllPositions();
        model.addAttribute("positions",positions);
        return "positions_archive";
    }


    @GetMapping("/updatePosition/{id}")
    public String doUpdatePositionGet(@PathVariable Long id,Model model)
    {
        Position position=positionService.getPositionById(id);
        model.addAttribute("position",position);
        return "update_position";
    }
}
