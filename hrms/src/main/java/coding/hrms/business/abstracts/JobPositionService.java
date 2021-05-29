package coding.hrms.business.abstracts;

import coding.hrms.core.business.BaseService;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.JobPosition;

public interface JobPositionService extends BaseService<JobPosition> {
	Result isNotExistsJobPosition(final String title);
}