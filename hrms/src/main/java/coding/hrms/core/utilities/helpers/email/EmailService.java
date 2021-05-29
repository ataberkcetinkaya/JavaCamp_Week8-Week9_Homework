package coding.hrms.core.utilities.helpers.email;

import coding.hrms.core.utilities.results.Result;

public interface EmailService {
	Result send(String to, String title, String body);
}
