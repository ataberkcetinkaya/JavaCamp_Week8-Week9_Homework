package coding.hrms.business.abstracts;

import coding.hrms.core.business.BaseService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.JobSeeker;
import coding.hrms.entities.dtos.JobSeekerForRegisterDto;

public interface JobSeekerService extends BaseService<JobSeeker> {
	DataResult<JobSeeker> getByIdentityNumber(String identityNumber);

	Result isNotNationalIdentityExist(String identityNumber);

	Result register(JobSeekerForRegisterDto jobSeekerForRegisterDto);
}
