package coding.hrms.business.abstracts;

import coding.hrms.core.business.BaseService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.User;

public interface UserService extends BaseService<User> {
	DataResult<User> getByEmail(String email);

	Result isNotEmailExist(final String email);
}