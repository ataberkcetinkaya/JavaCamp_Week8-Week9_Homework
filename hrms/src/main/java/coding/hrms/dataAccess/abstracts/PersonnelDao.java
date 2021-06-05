package coding.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import coding.hrms.entities.concretes.Personnel;

public interface PersonnelDao extends JpaRepository<Personnel, Integer> {
}