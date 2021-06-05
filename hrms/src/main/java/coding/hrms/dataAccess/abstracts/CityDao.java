package coding.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import coding.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
}
