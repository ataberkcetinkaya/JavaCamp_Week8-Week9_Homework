package coding.hrms.business.abstracts;

import java.util.List;

import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.Employer;
import coding.hrms.entities.dtos.EmployerSaveDto;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    DataResult<Employer> getById(int id);
    DataResult<Employer> getByEmail(String email);

    Result save(EmployerSaveDto employer);
}
