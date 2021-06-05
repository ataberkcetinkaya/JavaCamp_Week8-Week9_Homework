package coding.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import coding.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer> {
}
