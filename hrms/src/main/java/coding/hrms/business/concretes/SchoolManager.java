package coding.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.hrms.business.abstracts.ResumeService;
import coding.hrms.business.abstracts.SchoolService;
import coding.hrms.business.constants.MessageResults;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.ErrorResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessDataResult;
import coding.hrms.core.utilities.results.SuccessResult;
import coding.hrms.core.utilities.tools.StringTools;
import coding.hrms.dataAccess.abstracts.SchoolDao;
import coding.hrms.entities.concretes.Resume;
import coding.hrms.entities.concretes.School;
import coding.hrms.entities.dtos.SchoolSaveDto;

@Service
public class SchoolManager implements SchoolService {

    private final SchoolDao schoolDao;
    private final ResumeService resumeService;
    private final String FIELD = "school";

    @Autowired
    public SchoolManager(SchoolDao schoolDao, ResumeService resumeService){
        this.schoolDao = schoolDao;
        this.resumeService = resumeService;
    }

    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(this.schoolDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<School> getById(int id) {
        return new SuccessDataResult<School>(this.schoolDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<List<School>> getByIds(List<Integer> ids) {
        List<School> schools = new ArrayList<>();

        for(var id : ids){
            DataResult<School> schoolDataResult = getById(id);
            if(schoolDataResult.isSuccess()){
                schools.add(schoolDataResult.getData());
            }
        }

        return new SuccessDataResult<List<School>>(schools, MessageResults.allDataListed(FIELD));
    }

    public Result save(SchoolSaveDto school) {
        if(StringTools.isStringNullOrEmpty(school.getSchool_name()) ||
                StringTools.isStringNullOrEmpty(school.getSchool_department()) ||
                StringTools.isStringNullOrEmpty(String.valueOf(school.getStartYear()))){
            return new ErrorResult(MessageResults.emptyFields);
        }
        Resume resume = resumeService.getById(school.getResumeId()).getData();

        School schoolObject = new School(
                resume,
                school.getSchool_name(),
                school.getSchool_department(),
                school.getStartYear(),
                school.getEndYear()
        );
        this.schoolDao.save(schoolObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }
}
