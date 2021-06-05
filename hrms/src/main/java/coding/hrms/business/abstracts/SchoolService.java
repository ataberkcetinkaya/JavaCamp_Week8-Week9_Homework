package coding.hrms.business.abstracts;

import java.util.List;

import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.School;
import coding.hrms.entities.dtos.SchoolSaveDto;

public interface SchoolService {
    DataResult<List<School>> getAll();
    DataResult<School> getById(int id);
    DataResult<List<School>> getByIds(List<Integer> ids);

    Result save(SchoolSaveDto school);
}