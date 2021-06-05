package coding.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import coding.hrms.entities.concretes.Ability;

public interface AbilityDao extends JpaRepository<Ability, Integer> {
}

