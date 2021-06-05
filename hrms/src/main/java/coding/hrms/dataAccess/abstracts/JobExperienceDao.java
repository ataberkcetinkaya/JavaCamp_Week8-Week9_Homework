package coding.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import coding.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {
}
