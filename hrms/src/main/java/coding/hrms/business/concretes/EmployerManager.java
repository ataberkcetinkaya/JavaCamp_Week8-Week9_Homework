package coding.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.hrms.business.abstracts.EmployerService;
import coding.hrms.business.abstracts.UserService;
import coding.hrms.business.constants.MessageResults;
import coding.hrms.core.utilities.helpers.EmailService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.ErrorResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessDataResult;
import coding.hrms.core.utilities.results.SuccessResult;
import coding.hrms.core.utilities.tools.StringTools;
import coding.hrms.dataAccess.abstracts.EmployerDao;
import coding.hrms.entities.concretes.Employer;
import coding.hrms.entities.concretes.User;
import coding.hrms.entities.dtos.EmployerSaveDto;

@Service
public class EmployerManager implements EmployerService {
    private final EmployerDao employerDao;
    private final UserService userService;
    private final EmailService emailService;
    private final String FIELD = "employer";

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserService userService, EmailService emailService){
        super();
        this.employerDao = employerDao;
        this.userService = userService;
        this.emailService = emailService;
    }

    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Employer> getById(int id) {
        return new SuccessDataResult<Employer>(this.employerDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<Employer> getByEmail(String email) {
        return new SuccessDataResult<Employer>(this.employerDao.getByUser_Email(email), MessageResults.dataListed(FIELD));
    }

    public Result save(EmployerSaveDto employer) {
        if(StringTools.isStringNullOrEmpty(employer.getCompanyName()) ||
                StringTools.isStringNullOrEmpty(employer.getWebsite()) ||
                StringTools.isStringNullOrEmpty(employer.getPhone()) ||
                StringTools.isStringNullOrEmpty(employer.getEmail()) ||
                StringTools.isStringNullOrEmpty(employer.getPassword()) ||
                StringTools.isStringNullOrEmpty(employer.getPasswordRetry())){
            return new ErrorResult(MessageResults.emptyFields);
        }


        if(!employer.getPassword().equals(employer.getPasswordRetry())){
            return new ErrorResult(MessageResults.passwordMatchFalse);
        }

        boolean checkEmail = emailService.checkWithDomain(employer.getEmail(), employer.getWebsite()).isSuccess();
        if(!checkEmail){
            return new ErrorResult(MessageResults.isEmailFormatFalse);
        }

       Employer byEmail = getByEmail(employer.getEmail()).getData();

        if(byEmail != null){
            return new ErrorResult(MessageResults.alreadyExists("email"));
        }

        User user = new User(
                employer.getEmail(),
                employer.getPassword(),
                false
        );
        userService.save(user);

        Employer employerObject = new Employer(
                user.getId(),
                employer.getCompanyName(),
                employer.getWebsite(),
                employer.getPhone(),
                false
        );
        this.employerDao.save(employerObject);
        return new SuccessResult(MessageResults.saved(FIELD, MessageResults.validateEmailBySystem));
    }
}
