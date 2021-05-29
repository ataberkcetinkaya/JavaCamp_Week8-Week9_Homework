package coding.hrms.business.abstracts;

import java.util.List;

import coding.hrms.core.business.BaseService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.entities.concretes.City;

public interface CityService extends BaseService<City> {
	DataResult<City> getByName(String name);

	DataResult<List<City>> getByNameContains(String name);
}
