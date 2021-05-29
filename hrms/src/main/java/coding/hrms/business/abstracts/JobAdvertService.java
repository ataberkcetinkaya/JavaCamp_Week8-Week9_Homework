package coding.hrms.business.abstracts;

import java.util.List;

import coding.hrms.core.business.BaseService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.JobAdvert;
import coding.hrms.entities.dtos.JobAdvertForListDto;

public interface JobAdvertService extends BaseService<JobAdvert> {
	Result disableById(int id);

	DataResult<List<JobAdvertForListDto>> getAllByIsActiveAndEmployer_CompanyNameForList(boolean isActive,
			String companyName);

	DataResult<List<JobAdvertForListDto>> getAllByIsActiveForList(boolean isActive);

	DataResult<List<JobAdvertForListDto>> getAllByIsActiveOrderByCreatedAtByForList(boolean isActive, String sort);
}