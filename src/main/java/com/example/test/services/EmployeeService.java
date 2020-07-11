package com.example.test.services;

import com.example.test.entities.Bank;
import com.example.test.entities.Employee;
import com.example.test.entities.Position;
import com.example.test.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BankService bankService;

    @Autowired
    private PositionService positionService;

    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id)
    {
        Optional<Employee> employee=employeeRepository.findById(id);
        return employee.orElse(null);
    }


    public void deleteEmployeeById(Long id)
    {
        employeeRepository.deleteById(id);
    }

    public void saveEmployee(Employee employee)
    {
        employeeRepository.save(employee);
    }


    public void saveNewEmployee(Employee employee,String bankName,String positionName)
    {
        Bank bank=bankService.getBankByName(bankName);
        employee.setBankOrganization(bank);
        Position position=positionService.getPositionByName(positionName);
        employee.setPosition(position);
        this.saveEmployee(employee);


    }

}
