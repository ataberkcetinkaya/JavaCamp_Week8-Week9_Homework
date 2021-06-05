package coding.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import coding.hrms.business.abstracts.EmployeeService;
import coding.hrms.business.abstracts.PositionService;
import coding.hrms.business.abstracts.UserService;
import coding.hrms.business.constants.MessageResults;
import coding.hrms.core.adapters.abstracts.UserCheckService;
import coding.hrms.core.adapters.concretes.FakeMernisServiceAdapter;
import coding.hrms.core.utilities.helpers.EmailService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.ErrorResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessDataResult;
import coding.hrms.core.utilities.results.SuccessResult;
import coding.hrms.core.utilities.tools.StringTools;
import coding.hrms.dataAccess.abstracts.EmployeeDao;
import coding.hrms.entities.concretes.Employee;
import coding.hrms.entities.concretes.Position;
import coding.hrms.entities.concretes.User;
import coding.hrms.entities.dtos.EmployeeSaveDto;

@Service
public class EmployeeManager implements EmployeeService {
    private final EmployeeDao employeeDao;
    private final UserService userService;
    private final PositionService positionService;
    private final UserCheckService userCheckService = new FakeMernisServiceAdapter();
    private final EmailService emailService;
    private final String FIELD = "employee";

    public EmployeeManager(EmployeeDao employeeDao, PositionService positionService, UserService userService, EmailService emailService){
        super();
        this.employeeDao = employeeDao;
        this.positionService = positionService;
        this.userService = userService;
        this.emailService = emailService;
    }

    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Employee> getById(int id) {
        return new SuccessDataResult<Employee>(this.employeeDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<Employee> getByEmail(String email) {
        return new SuccessDataResult<Employee>(this.employeeDao.getByUser_Email(email));
    }

    public DataResult<Employee> getByIdentityNo(String identityNo) {
        return new SuccessDataResult<Employee>(this.employeeDao.getByIdentityNo(identityNo));
    }

    public Result save(EmployeeSaveDto employee) {
        if (StringTools.isStringNullOrEmpty(employee.getFirstName()) ||
            StringTools.isStringNullOrEmpty(employee.getLastName()) ||
            StringTools.isStringNullOrEmpty(employee.getIdentityNo()) ||
            StringTools.isStringNullOrEmpty(String.valueOf(employee.getBirthYear())) ||
            StringTools.isStringNullOrEmpty(employee.getEmail()) ||
            StringTools.isStringNullOrEmpty(employee.getPassword()) ||
            StringTools.isStringNullOrEmpty(employee.getPasswordRetry()) ||
            StringTools.isStringNullOrEmpty(String.valueOf(employee.getPositionId()))){
            return new ErrorResult(MessageResults.emptyFields);
        }

        if(!employee.getPassword().equals(employee.getPasswordRetry())){
            return new ErrorResult(MessageResults.passwordMatchFalse);
        }

        boolean checkRealPerson = userCheckService.isRealPerson(employee.getIdentityNo(),employee.getFirstName(),employee.getLastName(),employee.getBirthYear());
        if(!checkRealPerson){
            return new ErrorResult(MessageResults.isRealPersonFalse);
        }


        boolean checkEmail = emailService.check(employee.getEmail()).isSuccess();
        if(!checkEmail){
            return new ErrorResult(MessageResults.isEmailFormatFalse);
        }

        Employee byEmail = getByEmail(employee.getEmail()).getData();
        Employee byIdentityNo = getByIdentityNo(employee.getIdentityNo()).getData();

        if(byEmail != null){
            return new ErrorResult(MessageResults.alreadyExists("email"));
        }

        if(byIdentityNo != null){
            return new ErrorResult(MessageResults.alreadyExists("identityNo"));
        }

        User user = new User(
                employee.getEmail(),
                employee.getPassword(),
                false
        );
        userService.save(user);

        Position position = positionService.getById(employee.getPositionId()).getData();

        Employee employeeObject = new Employee(
                user.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getIdentityNo(),
                employee.getBirthYear(),
                position
        );
        this.employeeDao.save(employeeObject);

        return new SuccessResult(MessageResults.saved(FIELD, MessageResults.validateEmail));
    }
}
