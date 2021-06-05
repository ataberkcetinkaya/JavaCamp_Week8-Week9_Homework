package coding.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.hrms.business.abstracts.UserService;
import coding.hrms.business.constants.MessageResults;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.ErrorResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessDataResult;
import coding.hrms.core.utilities.results.SuccessResult;
import coding.hrms.core.utilities.tools.StringTools;
import coding.hrms.dataAccess.abstracts.UserDao;
import coding.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {
    private final UserDao userDao;
    private final String FIELD = "user";

    @Autowired
    public UserManager(UserDao userDao){
        this.userDao = userDao;
    }

    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<User> getById(int id) {
        return new SuccessDataResult<User>(this.userDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.getByEmail(email), MessageResults.dataListed(FIELD));
    }

    public Result save(User user) {
        if(StringTools.isStringNullOrEmpty(user.getEmail()) ||
                StringTools.isStringNullOrEmpty(user.getPassword())){
            return new ErrorResult(MessageResults.emptyField);
        }

        this.userDao.save(user);
        return new SuccessResult(MessageResults.saved(FIELD));
    }

    public Result verifyById(int id) {
        User user = getById(id).getData();
        if(user == null){
            return new ErrorResult(MessageResults.verificationSuccessFalse);
        }

        user.setVerified(true);
        this.userDao.save(user);
        return new SuccessResult(MessageResults.verificationSuccessTrue);
    }

    public Result verifyByEmail(String email) {
        User user = getByEmail(email).getData();
        if(user == null){
            return new ErrorResult(MessageResults.verificationSuccessFalse);
        }

        user.setVerified(true);
        this.userDao.save(user);
        return new SuccessResult(MessageResults.verificationSuccessTrue);
    }
}