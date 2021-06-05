package coding.hrms.business.abstracts;

import java.util.List;

import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.entities.concretes.Image;
import coding.hrms.entities.dtos.ImageSaveDto;

public interface ImageService {
    DataResult<List<Image>> getAll();
    DataResult<Image> getById(int id);
    DataResult<List<Image>> getByIds(List<Integer> ids);

    Result save(ImageSaveDto image);
}