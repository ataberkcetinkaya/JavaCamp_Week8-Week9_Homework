package coding.hrms.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.hrms.business.abstracts.CityService;
import coding.hrms.business.abstracts.EmployerService;
import coding.hrms.business.abstracts.JobAdvertisementService;
import coding.hrms.business.abstracts.PositionService;
import coding.hrms.business.constants.MessageResults;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.ErrorResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessDataResult;
import coding.hrms.core.utilities.results.SuccessResult;
import coding.hrms.core.utilities.tools.StringTools;
import coding.hrms.dataAccess.abstracts.JobAdvertisementDao;
import coding.hrms.entities.concretes.JobAdvertisement;
import coding.hrms.entities.dtos.JobAdvertisementSaveDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private final JobAdvertisementDao jobAdvertisementDao;
    private final PositionService positionService;
    private final CityService cityService;
    private final EmployerService employerService;
    private final String FIELD = "jobAdvertisement";

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, PositionService positionService, CityService cityService, EmployerService employerService){
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.positionService = positionService;
        this.cityService = cityService;
        this.employerService = employerService;
    }

    public Result save(JobAdvertisementSaveDto jobAdvertisement) {
        if (StringTools.isStringNullOrEmpty(jobAdvertisement.getDescription()) ||
                StringTools.isStringNullOrEmpty(String.valueOf(jobAdvertisement.getOpenPositionsAmount())) ||
                StringTools.isStringNullOrEmpty(String.valueOf(jobAdvertisement.getCityId())) ||
                StringTools.isStringNullOrEmpty(String.valueOf(jobAdvertisement.getPositionId())) ||
                StringTools.isStringNullOrEmpty(String.valueOf(jobAdvertisement.getDeadline()))) {
            return new ErrorResult(MessageResults.emptyFields);
        }

        JobAdvertisement jobAdvertisementObject= new JobAdvertisement(
                jobAdvertisement.getDescription(),
                new Date(System.currentTimeMillis()),
                jobAdvertisement.getDeadline(),
                jobAdvertisement.getMinSalary(),
                jobAdvertisement.getMaxSalary(),
                jobAdvertisement.getOpenPositionsAmount(),
                true
        );

        jobAdvertisementObject.setCity(cityService.getById(jobAdvertisement.getCityId()).getData());
        jobAdvertisementObject.setPosition(positionService.getById(jobAdvertisement.getPositionId()).getData());
        jobAdvertisementObject.setEmployer(employerService.getById(jobAdvertisement.getEmployerId()).getData());

        this.jobAdvertisementDao.save(jobAdvertisementObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }


    public Result updateActive(boolean active, int id) {
        this.jobAdvertisementDao.updateActive(active, id);
        return new SuccessResult(MessageResults.updated(FIELD));
    }


    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getByActiveTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveTrue(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getByActiveTrueOrderByReleaseDate() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveTrueOrderByReleaseDate(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveTrueAndEmployer_UserId(employerId), MessageResults.allDataListed(FIELD));
    }

    public DataResult<JobAdvertisement> getById(int id) {
        return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }
}