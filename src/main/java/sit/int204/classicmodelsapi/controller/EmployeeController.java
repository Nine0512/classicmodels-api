package sit.int204.classicmodelsapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsapi.entity.Employee;
import sit.int204.classicmodelsapi.entity.Office;
import sit.int204.classicmodelsapi.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getByID(@PathVariable Integer id){
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id,@RequestBody Employee newValue){
        return service.updateEmployee(id,newValue);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.deleteEmployee(id);
    }

    @GetMapping("/{id}/offices")
    public Office getOffice(@PathVariable Integer id){
        return service.officeOfEmployee(id);
    }

    @PostMapping("/{officeCode}")
    public Employee addNewEmployee(@PathVariable String officeCode,@RequestBody Employee newEmployee){
        return service.addNewEmployee(officeCode,newEmployee);
    }

    @GetMapping("/{id}/reportTo")
    public Employee getManager(@PathVariable Integer id){
        return service.getReportsToEmployee(id);
    }
}
