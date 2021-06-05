package coding.hrms.business.abstracts;

import java.util.List;

import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.entities.concretes.Position;

public interface PositionService {
    DataResult<Position> save(Position position);
    
    ////////
    
    DataResult<Position> delete(Position position);
    DataResult<Integer> deleteById(int id);
    
    ////////
    
    DataResult<List<Position>> getAll();
    DataResult<Position> getById(int id);
    DataResult<Position> getByPositionName(String positionName);
}
