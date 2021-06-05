package coding.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.hrms.business.abstracts.LanguageService;
import coding.hrms.business.abstracts.ResumeService;
import coding.hrms.business.constants.MessageResults;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.ErrorResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessDataResult;
import coding.hrms.core.utilities.results.SuccessResult;
import coding.hrms.core.utilities.tools.StringTools;
import coding.hrms.dataAccess.abstracts.LanguageDao;
import coding.hrms.entities.concretes.Language;
import coding.hrms.entities.concretes.Resume;
import coding.hrms.entities.dtos.LanguageSaveDto;

@Service
public class LanguageManager implements LanguageService {
    private final LanguageDao languageDao;
    private final ResumeService resumeService;
    private final String FIELD = "language";

    @Autowired
    private LanguageManager(LanguageDao languageDao, ResumeService resumeService){
        this.languageDao = languageDao;
        this.resumeService = resumeService;
    }


    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Language> getById(int id) {
        return new SuccessDataResult<Language>(this.languageDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<List<Language>> getByIds(List<Integer> ids) {
        List<Language> languages = new ArrayList<>();

        for(var id : ids){
            DataResult<Language> languageDataResult = getById(id);
            if(languageDataResult.isSuccess()){
                languages.add(languageDataResult.getData());
            }
        }

        return new SuccessDataResult<List<Language>>(languages, MessageResults.allDataListed(FIELD));
    }

    public Result save(LanguageSaveDto language) {
        if(StringTools.isStringNullOrEmpty(language.getLanguageName()) ||
                StringTools.isStringNullOrEmpty(String.valueOf(language.getLanguageLevel()))){
            return new ErrorResult(MessageResults.emptyFields);
        }

        Language languageObject = new Language(
                new Resume(),
                language.getLanguageName(),
                language.getLanguageLevel()
        );

        this.languageDao.save(languageObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }
}
