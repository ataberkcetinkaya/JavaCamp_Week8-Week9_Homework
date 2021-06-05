package coding.hrms.core.utilities.helpers;

import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.User;

public interface EmailService {
    Result send(User user);
    Result check(String email);
    Result checkWithDomain(String email, String website);
}