package coding.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import coding.hrms.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position, Integer> {
    Position getByPositionName(String positionName);
}
