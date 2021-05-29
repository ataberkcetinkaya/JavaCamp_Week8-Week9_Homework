package coding.hrms.business.abstracts;

import coding.hrms.core.business.BaseService;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.Employer;
import coding.hrms.entities.dtos.EmployerForRegisterDto;

public interface EmployerService extends BaseService<Employer> {
	Result isNotCorporateEmailExist(final String corporateEmail);

	Result register(EmployerForRegisterDto employerForRegister);
}
