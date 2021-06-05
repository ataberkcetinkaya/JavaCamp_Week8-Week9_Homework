package coding.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.hrms.business.abstracts.PersonnelService;
import coding.hrms.business.abstracts.UserService;
import coding.hrms.business.constants.MessageResults;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.ErrorResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessDataResult;
import coding.hrms.core.utilities.results.SuccessResult;
import coding.hrms.core.utilities.tools.StringTools;
import coding.hrms.dataAccess.abstracts.PersonnelDao;
import coding.hrms.entities.concretes.Personnel;
import coding.hrms.entities.concretes.User;
import coding.hrms.entities.dtos.PersonnelSaveDto;

@Service
public class PersonnelManager implements PersonnelService {
    private final PersonnelDao personnelDao;
    private final UserService userService;
    private final String FIELD = "personnel";

    @Autowired
    public PersonnelManager(PersonnelDao personnelDao, UserService userService){
        this.personnelDao = personnelDao;
        this.userService = userService;
    }

    public DataResult<List<Personnel>> getAll() {
        return new SuccessDataResult<List<Personnel>>(this.personnelDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Personnel> getById(int id) {
        return new SuccessDataResult<Personnel>(this.personnelDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public Result save(PersonnelSaveDto personnel) {
        if (StringTools.isStringNullOrEmpty(personnel.getFirstName()) ||
                StringTools.isStringNullOrEmpty(personnel.getLastName()) ||
                StringTools.isStringNullOrEmpty(personnel.getEmail()) ||
                StringTools.isStringNullOrEmpty(personnel.getPassword()) ||
                StringTools.isStringNullOrEmpty(personnel.getPasswordRetry())){
            return new ErrorResult(MessageResults.emptyFields);
        }

        User user = new User(
                personnel.getEmail(),
                personnel.getPassword(),
                true
        );
        userService.save(user);

        Personnel personnelObject = new Personnel(
                user.getId(),
                personnel.getFirstName(),
                personnel.getLastName()
        );

        this.personnelDao.save(personnelObject);

        return new SuccessResult(MessageResults.saved(FIELD, MessageResults.validateEmail));
    }
}