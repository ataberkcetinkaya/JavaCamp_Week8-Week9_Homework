package coding.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import coding.hrms.business.abstracts.PositionService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.entities.concretes.Position;

@RestController
@RequestMapping("/api/positions")
public class PositionsController {
    private PositionService positionService;

    @Autowired
    public PositionsController(PositionService positionService){
        super();
        this.positionService = positionService;
    }

    @GetMapping("")
    public DataResult<List<Position>> getAll()  {
        return this.positionService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Position> getById(@PathVariable(value = "id") int id){
        return this.positionService.getById(id);
    }

    @PostMapping("")
    public DataResult<Position> save(@RequestParam String positionName){
        return this.positionService.save(new Position(positionName));
    }

    @DeleteMapping("")
    public DataResult<Position> delete(@RequestBody Position position){
        return this.positionService.delete(position);
    }

    @DeleteMapping("/{id}")
    public DataResult<Integer> deleteById(@PathVariable(value = "id") int id){
        return this.positionService.deleteById(id);
    }


}
