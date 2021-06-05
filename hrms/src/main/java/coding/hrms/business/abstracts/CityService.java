package coding.hrms.business.abstracts;

import java.util.List;

import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.entities.concretes.City;

public interface CityService {
    DataResult<List<City>> getAll();
    DataResult<City> getById(int id);
}
