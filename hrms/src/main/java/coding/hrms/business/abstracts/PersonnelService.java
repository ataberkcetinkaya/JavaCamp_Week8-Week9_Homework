package coding.hrms.business.abstracts;

import java.util.List;

import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.Personnel;
import coding.hrms.entities.dtos.PersonnelSaveDto;

public interface PersonnelService {
    DataResult<List<Personnel>> getAll();
    DataResult<Personnel> getById(int id);

    Result save(PersonnelSaveDto personnel);
}