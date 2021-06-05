package coding.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import coding.hrms.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer> {
}
