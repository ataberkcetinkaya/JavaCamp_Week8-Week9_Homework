package coding.hrms.business.abstracts;

import java.util.List;

import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.Resume;
import coding.hrms.entities.dtos.ResumeSaveDto;

public interface ResumeService {
    DataResult<List<Resume>> getAll();
    DataResult<Resume> getById(int id);

    Result save(ResumeSaveDto resume);
}
