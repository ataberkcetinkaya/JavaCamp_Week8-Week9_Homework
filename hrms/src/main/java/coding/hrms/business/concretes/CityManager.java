package coding.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.hrms.business.abstracts.CityService;
import coding.hrms.business.constants.MessageResults;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.SuccessDataResult;
import coding.hrms.dataAccess.abstracts.CityDao;
import coding.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {
    private CityDao cityDao;
    private String FIELD = "city";

    @Autowired
    public CityManager(CityDao cityDao){
        this.cityDao = cityDao;
    }

    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>(this.cityDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }
}
