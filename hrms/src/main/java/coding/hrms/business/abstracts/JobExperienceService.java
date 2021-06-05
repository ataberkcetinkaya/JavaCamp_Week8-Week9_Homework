package coding.hrms.business.abstracts;

import java.util.List;

import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.JobExperience;
import coding.hrms.entities.dtos.JobExperienceSaveDto;

public interface JobExperienceService {
    DataResult<List<JobExperience>> getAll();
    DataResult<JobExperience> getById(int id);
    DataResult<List<JobExperience>> getByIds(List<Integer> ids);


    Result save(JobExperienceSaveDto jobExperience);
}
