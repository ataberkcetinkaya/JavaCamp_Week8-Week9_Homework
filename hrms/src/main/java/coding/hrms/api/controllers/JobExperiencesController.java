package coding.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coding.hrms.business.abstracts.JobExperienceService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.JobExperience;
import coding.hrms.entities.dtos.JobExperienceSaveDto;

@RestController
@RequestMapping("/api/jobExperiences")
public class JobExperiencesController {
    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperiencesController(JobExperienceService jobExperienceService){
        this.jobExperienceService = jobExperienceService;
    }
    
    @GetMapping("")
    public DataResult<List<JobExperience>> getAll() {
        return this.jobExperienceService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<JobExperience> getById(@PathVariable(value = "id") int id) {
        return this.jobExperienceService.getById(id);
    }

    @PostMapping("")
    public Result save(@RequestBody JobExperienceSaveDto jobExperience){
        return this.jobExperienceService.save(jobExperience);
    }
}