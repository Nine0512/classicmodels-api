package sit.int204.classicmodelsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsapi.entity.Employee;
import sit.int204.classicmodelsapi.entity.Office;
import sit.int204.classicmodelsapi.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    @Autowired
    public OfficeService service;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Integer id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("don't have this employee"));
    }

    public Employee addNewEmployee(String officeCode,Employee newEmployee){
        Office office = service.getByOfficeCode(officeCode);
        newEmployee.setOffice(office);
        return repository.saveAndFlush(newEmployee);
    }

    public Employee updateEmployee(Integer id,Employee employee){
        Employee newEmployee = getEmployeeById(id);
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setExtension(employee.getExtension());
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setJobTitle(employee.getJobTitle());
        return repository.saveAndFlush(newEmployee);
    }

    public void deleteEmployee(Integer id){
        Employee employee = getEmployeeById(id);
        repository.delete(employee);
    }

    public Office officeOfEmployee(Integer id){
        return getEmployeeById(id).getOffice();
    }

    public Employee getReportsToEmployee(Integer id){
        return getEmployeeById(id).getEmployees();
    }
}
