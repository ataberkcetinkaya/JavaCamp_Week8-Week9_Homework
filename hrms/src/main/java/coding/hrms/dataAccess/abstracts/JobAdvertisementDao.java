package coding.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import coding.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> getByActiveTrue();
    List<JobAdvertisement> getByActiveTrueOrderByReleaseDate();
    List<JobAdvertisement> getByActiveTrueAndEmployer_UserId(int employerId);

    @Transactional
    @Modifying
    @Query("update JobAdvertisement j set j.active=:active where j.id=:id")
    void updateActive(boolean active, int id);
}
