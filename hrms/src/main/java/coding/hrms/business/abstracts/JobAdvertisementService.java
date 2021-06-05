package coding.hrms.business.abstracts;

import java.util.List;

import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.JobAdvertisement;
import coding.hrms.entities.dtos.JobAdvertisementSaveDto;

public interface JobAdvertisementService {
    Result save(JobAdvertisementSaveDto jobAdvertisement);

    Result updateActive(boolean active, int id);

    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getByActiveTrue();
    DataResult<List<JobAdvertisement>> getByActiveTrueOrderByReleaseDate();
    DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerId(int employerId);
    DataResult<JobAdvertisement> getById(int id);
}
