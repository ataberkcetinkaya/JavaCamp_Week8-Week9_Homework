package coding.hrms.business.abstracts;

import coding.hrms.business.adapters.mernisService.PersonForValidateFromMernisService;
import coding.hrms.core.business.BaseService;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.MernisActivation;

public interface MernisActivationService extends BaseService<MernisActivation> {
	Result check(PersonForValidateFromMernisService personForValidateFromMernisService);
}
