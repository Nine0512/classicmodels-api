package sit.int204.classicmodelsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import sit.int204.classicmodelsapi.entity.Employee;
import sit.int204.classicmodelsapi.entity.Office;
import sit.int204.classicmodelsapi.repository.OfficeRepository;

import java.util.List;
import java.util.Set;

@Service
public class OfficeService {
    @Autowired
    private OfficeRepository repository;

    public List<Office> getAllOffices() {
        return repository.findAll();
    }

    public Office getByOfficeCode(String officeCode) {
        return repository.findById(officeCode).orElseThrow(() -> new RuntimeException("Don't have this code"));
    }

    public Office addNewOffice(Office newOffice) {
        return repository.saveAndFlush(newOffice);
    }

    public Office updataOffice(String officeCode, Office office) {
        Office newOffice = getByOfficeCode(officeCode);
        newOffice.setCity(office.getCity());
        newOffice.setCountry(office.getCountry());
        newOffice.setAddressLine1(office.getAddressLine1());
        newOffice.setAddressLine2(office.getAddressLine2());
        newOffice.setPhone(office.getPhone());
        return repository.saveAndFlush(newOffice);
    }

    public void deleteOffice(String officeCode) {
        Office office = getByOfficeCode(officeCode);
        repository.delete(office);
    }

    public Set<Employee> getEmployees(String officeCode) {
        return getByOfficeCode(officeCode).getEmployees();
    }

}
