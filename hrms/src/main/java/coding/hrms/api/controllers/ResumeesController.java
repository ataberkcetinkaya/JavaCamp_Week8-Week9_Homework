package coding.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coding.hrms.business.abstracts.ResumeService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.Resume;
import coding.hrms.entities.dtos.ResumeSaveDto;

@RestController
@RequestMapping("/api/resumes")
public class ResumeesController {
    private ResumeService resumeService;

    @Autowired
    public ResumeesController(ResumeService resumeService){
        this.resumeService = resumeService;
    }

    @GetMapping("")
    public DataResult<List<Resume>> getAll() {
        return this.resumeService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Resume> getById(@PathVariable(value = "id") int id) {
        return this.resumeService.getById(id);
    }

    @PostMapping("")
    public Result save(@Valid @RequestBody ResumeSaveDto resume){
        return this.resumeService.save(resume);
    }
}
