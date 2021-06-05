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

import coding.hrms.business.abstracts.EmployerService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.Employer;
import coding.hrms.entities.dtos.EmployerSaveDto;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService){
        this.employerService = employerService;
    }

    @GetMapping("")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Employer> getById(@PathVariable(value = "id") int id){
        return this.employerService.getById(id);
    }

    @GetMapping("/getByEmail")
    public DataResult<Employer> getByEmail(@RequestParam(value = "email") String email) {
        return this.employerService.getByEmail(email);
    }

    @PostMapping("")
    public Result save(@RequestBody EmployerSaveDto employer) {
        return this.employerService.save(employer);
    }
}
