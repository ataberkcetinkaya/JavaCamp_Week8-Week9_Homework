package coding.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coding.hrms.business.abstracts.CityService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService){
        super();
        this.cityService = cityService;
    }

    @GetMapping("")
    public DataResult<List<City>> getAll()  {
        return this.cityService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<City> getById(@PathVariable(value = "id") int id){
        return this.cityService.getById(id);
    }

}