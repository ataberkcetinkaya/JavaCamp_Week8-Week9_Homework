package coding.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coding.hrms.business.abstracts.PersonnelService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.Personnel;
import coding.hrms.entities.dtos.PersonnelSaveDto;

@RestController
@RequestMapping("/api/personnels")
public class PersonnelsController {
    private PersonnelService personnelService;

    @Autowired
    public PersonnelsController(PersonnelService personnelService){
        this.personnelService = personnelService;
    }

    @GetMapping("")
    public DataResult<List<Personnel>> getAll(){
        return this.personnelService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Personnel> getById(@PathVariable(value = "id") int id){
        return this.personnelService.getById(id);
    }


    @PostMapping("")
    public Result save(@Valid @RequestBody PersonnelSaveDto personnel){
        return this.personnelService.save(personnel);
    }
}
