package coding.hrms.core.adapters.concretes;

import org.springframework.stereotype.Component;

import coding.hrms.core.adapters.abstracts.UserCheckService;

@Component
public class FakeMernisServiceAdapter implements UserCheckService {
    public boolean isRealPerson(String identityNo, String firstName, String lastName, int birthYear) {
        return true;
    }
}
