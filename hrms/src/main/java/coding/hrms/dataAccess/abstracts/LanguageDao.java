package coding.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import coding.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {
}
