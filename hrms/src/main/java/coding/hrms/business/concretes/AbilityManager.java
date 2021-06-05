package coding.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.hrms.business.abstracts.AbilityService;
import coding.hrms.business.abstracts.ResumeService;
import coding.hrms.business.constants.MessageResults;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.ErrorResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessDataResult;
import coding.hrms.core.utilities.results.SuccessResult;
import coding.hrms.dataAccess.abstracts.AbilityDao;
import coding.hrms.entities.concretes.Ability;
import coding.hrms.entities.concretes.Resume;
import coding.hrms.entities.dtos.AbilitySaveDto;

@Service
public class AbilityManager implements AbilityService {

    private final AbilityDao abilityDao;
    private final ResumeService resumeService;
    private final String FIELD = "ability";


    @Autowired
    public AbilityManager(AbilityDao abilityDao, ResumeService resumeService){
        this.abilityDao = abilityDao;
        this.resumeService = resumeService;
    }

    public DataResult<List<Ability>> getAll() {
        return new SuccessDataResult<List<Ability>>(this.abilityDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Ability> getById(int id) {
        return new SuccessDataResult<Ability>(this.abilityDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<List<Ability>> getByIds(List<Integer> ids) {
        List<Ability> abilities = new ArrayList<>();

        for(var id : ids){
            DataResult<Ability> abilityDataResult = getById(id);
            if(abilityDataResult.isSuccess()){
               abilities.add(abilityDataResult.getData());
            }
        }

        return new SuccessDataResult<List<Ability>>(abilities, MessageResults.allDataListed(FIELD));
    }

    public Result save(AbilitySaveDto ability) {
        DataResult<Resume> resume = resumeService.getById(ability.getResumeId());

        if(!resume.isSuccess()){
            return new ErrorResult(MessageResults.notFound(FIELD));
        }

        Ability abilityObject = new Ability(
            resume.getData(),
            ability.getAbilityName()
        );

        this.abilityDao.save(abilityObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }
}
