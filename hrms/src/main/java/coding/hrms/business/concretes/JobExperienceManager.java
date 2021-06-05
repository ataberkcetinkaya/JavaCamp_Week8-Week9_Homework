package coding.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.hrms.business.abstracts.JobExperienceService;
import coding.hrms.business.abstracts.ResumeService;
import coding.hrms.business.constants.MessageResults;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.ErrorResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessDataResult;
import coding.hrms.core.utilities.results.SuccessResult;
import coding.hrms.core.utilities.tools.StringTools;
import coding.hrms.dataAccess.abstracts.JobExperienceDao;
import coding.hrms.entities.concretes.JobExperience;
import coding.hrms.entities.concretes.Resume;
import coding.hrms.entities.dtos.JobExperienceSaveDto;

@Service
public class JobExperienceManager implements JobExperienceService {
    private final JobExperienceDao jobExperienceDao;
    private final ResumeService resumeService;
    private final String FIELD = "jobExperience";

    @Autowired
    private JobExperienceManager(JobExperienceDao jobExperienceDao, ResumeService resumeService){
        this.jobExperienceDao = jobExperienceDao;
        this.resumeService = resumeService;
    }

    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<JobExperience> getById(int id) {
        return new SuccessDataResult<JobExperience>(this.jobExperienceDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<List<JobExperience>> getByIds(List<Integer> ids) {
        List<JobExperience> jobExperiences = new ArrayList<>();

        for(var id : ids){
            DataResult<JobExperience> jobExperienceDataResult = getById(id);
            if(jobExperienceDataResult.isSuccess()){
                jobExperiences.add(jobExperienceDataResult.getData());
            }
        }

        return new SuccessDataResult<List<JobExperience>>(jobExperiences, MessageResults.allDataListed(FIELD));
    }

    public Result save(JobExperienceSaveDto jobExperience) {
        if(StringTools.isStringNullOrEmpty(jobExperience.getCompanyName()) ||
                StringTools.isStringNullOrEmpty(jobExperience.getPositionName()) ||
                StringTools.isStringNullOrEmpty(String.valueOf(jobExperience.getStartYear()))){
            return new ErrorResult(MessageResults.emptyField);
        }
        Resume resume = resumeService.getById(jobExperience.getResumeId()).getData();

        JobExperience jobExperienceObject = new JobExperience(
                resume,
                jobExperience.getCompanyName(),
                jobExperience.getPositionName(),
                jobExperience.getStartYear(),
                jobExperience.getEndYear()
        );

        this.jobExperienceDao.save(jobExperienceObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }


}
