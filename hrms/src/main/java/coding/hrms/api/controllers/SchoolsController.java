package coding.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coding.hrms.business.abstracts.SchoolService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.School;
import coding.hrms.entities.dtos.SchoolSaveDto;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
    private SchoolService schoolService;

    @Autowired
    public SchoolsController(SchoolService schoolService){
        this.schoolService = schoolService;
    }

    @GetMapping("")
    public DataResult<List<School>> getAll() {
        return this.schoolService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<School> getById(@PathVariable(value = "id") int id) {
        return this.schoolService.getById(id);
    }

    @PostMapping("")
    public Result save(@RequestBody SchoolSaveDto school){
        return this.schoolService.save(school);
    }
}
