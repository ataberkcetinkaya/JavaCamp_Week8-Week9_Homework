package coding.hrms.business.abstracts;

import coding.hrms.core.business.BaseService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.CompanyStaffVerification;

public interface CompanyStaffVerificationService extends BaseService<CompanyStaffVerification> {
	DataResult<CompanyStaffVerification> getByUserId(final int userId);

	Result verify(int id);
}