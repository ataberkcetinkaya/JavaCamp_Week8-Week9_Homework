package coding.hrms.business.abstracts;

import java.util.List;

import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.Ability;
import coding.hrms.entities.dtos.AbilitySaveDto;

public interface AbilityService {
    DataResult<List<Ability>> getAll();
    DataResult<Ability> getById(int id);
    DataResult<List<Ability>> getByIds(List<Integer> ids);

    Result save(AbilitySaveDto ability);
}
