package coding.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import coding.hrms.business.abstracts.JobAdvertisementService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.JobAdvertisement;
import coding.hrms.entities.dtos.JobAdvertisementSaveDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService cityService){
        super();
        this.jobAdvertisementService = cityService;
    }

    @PostMapping("")
    public Result save(@RequestBody JobAdvertisementSaveDto jobAdvertisement){
        return this.jobAdvertisementService.save(jobAdvertisement);
    }

    @PutMapping("/changeActive")
    public Result changeActive(@RequestParam(value = "active") boolean active, @RequestParam(value = "id") int id){
        return this.jobAdvertisementService.updateActive(active,id);
    }

    @GetMapping("")
    public DataResult<List<JobAdvertisement>> getAll()  {
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<JobAdvertisement> getById(@PathVariable(value = "id") int id){
        return this.jobAdvertisementService.getById(id);
    }

    @GetMapping("/getByActiveTrue")
    public DataResult<List<JobAdvertisement>> getByActiveTrue(){
        return this.jobAdvertisementService.getByActiveTrue();
    }

    @GetMapping("/getByActiveTrueOrderByReleaseDate")
    public DataResult<List<JobAdvertisement>> getByActiveTrueOrderByReleaseDate(){
        return this.jobAdvertisementService.getByActiveTrueOrderByReleaseDate();
    }

    @GetMapping("/getByActiveTrueAndEmployerId")
    public DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerId(@RequestParam(value = "employerId") int employerId){
        return this.jobAdvertisementService.getByActiveTrueAndEmployerId(employerId);
    }

}
