package sit.int204.classicmodelsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsapi.entity.Employee;
import sit.int204.classicmodelsapi.entity.Office;
import sit.int204.classicmodelsapi.service.EmployeeService;
import sit.int204.classicmodelsapi.service.OfficeService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
    @Autowired
    private OfficeService service;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public List<Office> getOffices() {
        return service.getAllOffices();
    }

    @GetMapping("/{officeCode}")
    public Office getByOfficeCode(@PathVariable String officeCode) {
        return service.getByOfficeCode(officeCode);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Office addNewOffice(@RequestBody Office newOffice) {
        return service.addNewOffice(newOffice);
    }

    @PutMapping("/{officeCode}")
    public Office updateOffice(@PathVariable String officeCode, @RequestBody Office newValue) {
        return service.updataOffice(officeCode, newValue);
    }

    @DeleteMapping("/{officeCode}")
    public void delete(@PathVariable String officeCode) {
        service.deleteOffice(officeCode);
    }

    @GetMapping("/{officeCode}/employees")
    public Set<Employee> getEmployees(@PathVariable String officeCode) {
        return service.getEmployees(officeCode);
    }

    @PostMapping("/{officeCode}/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addNewEmployees(@PathVariable String officeCode, @RequestBody Employee newEmployee) {
        return employeeService.addNewEmployee(officeCode,newEmployee);
    }
}
