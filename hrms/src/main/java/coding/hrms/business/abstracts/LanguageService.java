package coding.hrms.business.abstracts;

import java.util.List;

import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.Language;
import coding.hrms.entities.dtos.LanguageSaveDto;

public interface LanguageService {
    DataResult<List<Language>> getAll();
    DataResult<Language> getById(int id);
    DataResult<List<Language>> getByIds(List<Integer> ids);

    Result save(LanguageSaveDto language);
}
