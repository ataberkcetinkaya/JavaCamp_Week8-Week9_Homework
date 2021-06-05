package coding.hrms.core.adapters.concretes;

import org.springframework.stereotype.Component;

import coding.hrms.core.adapters.abstracts.UserCheckService;

@Component
public class MernisServiceAdapter implements UserCheckService {
    public boolean isRealPerson(String identityNo, String firstName, String lastName, int birthYear) {
        PublicSoap soapClient = new PublicSoap();
        boolean checkResult = false;
        try{
            checkResult = soapClient.TCVerify(Long.parseLong(identityNo), firstName, lastName, birthYear);
        }
        catch (Exception e){
            System.out.println("Mernis Error");
        }
        return checkResult;
    }
}
