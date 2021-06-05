package coding.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import coding.hrms.business.abstracts.EmployeeService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.Employee;
import coding.hrms.entities.dtos.EmployeeSaveDto;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    
    @GetMapping("")
    public DataResult<List<Employee>> getAll() {
        return this.employeeService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Employee> getById(@PathVariable(value = "id") int id) {
        return this.employeeService.getById(id);
    }

    @GetMapping("/getByEmail")
    public DataResult<Employee> getByEmail(@RequestParam(value = "email") String email) {
        return this.employeeService.getByEmail(email);
    }

    @GetMapping("/getByIdentityNo")
    public DataResult<Employee> getByIdentityNo(@RequestParam(value = "identityNo") String identityNo) {
        return this.employeeService.getByIdentityNo(identityNo);
    }

    @PostMapping("")
    public Result save(@Valid @RequestBody EmployeeSaveDto employee) {
        return this.employeeService.save(employee);
    }
}
