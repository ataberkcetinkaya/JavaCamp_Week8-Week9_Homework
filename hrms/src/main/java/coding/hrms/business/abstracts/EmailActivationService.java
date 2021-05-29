package coding.hrms.business.abstracts;

import coding.hrms.core.business.BaseService;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.EmailActivation;
import coding.hrms.entities.concretes.User;
import coding.hrms.entities.dtos.EmailActivationForVerifyDto;

public interface EmailActivationService extends BaseService<EmailActivation> {
	Result createAndSendActivationCodeByMail(User user, String... emails);

	Result verify(EmailActivationForVerifyDto emailActivationForVerifyDto);
}
