package coding.hrms.core.utilities.helpers.email;

import org.springframework.stereotype.Service;

import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailManager implements EmailService {

	@Override
	public Result send(final String to, final String title, final String body) {
		return new SuccessResult("Email sent.");
	}

}