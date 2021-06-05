package coding.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding.hrms.business.abstracts.ImageService;
import coding.hrms.business.abstracts.ResumeService;
import coding.hrms.business.constants.MessageResults;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.ErrorResult;
import coding.hrms.core.utilities.results.Result;
import coding.hrms.core.utilities.results.SuccessDataResult;
import coding.hrms.core.utilities.results.SuccessResult;
import coding.hrms.dataAccess.abstracts.ImageDao;
import coding.hrms.entities.concretes.Image;
import coding.hrms.entities.concretes.Resume;
import coding.hrms.entities.dtos.ImageSaveDto;

@Service
public class ImageManager implements ImageService {

    private final ImageDao imageDao;
    private final ResumeService resumeService;
    private final String FIELD = "image";


    @Autowired
    public ImageManager(ImageDao imageDao, ResumeService resumeService){
        this.imageDao = imageDao;
        this.resumeService = resumeService;
    }

    public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<List<Image>>(this.imageDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Image> getById(int id) {
        return new SuccessDataResult<Image>(this.imageDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<List<Image>> getByIds(List<Integer> ids) {
        List<Image> images = new ArrayList<>();

        for(var id : ids){
            DataResult<Image> imageDataResult = getById(id);
            if(imageDataResult.isSuccess()){
                images.add(imageDataResult.getData());
            }
        }

        return new SuccessDataResult<List<Image>>(images, MessageResults.allDataListed(FIELD));
    }

    public Result save(ImageSaveDto image) {
        DataResult<Resume> resume = resumeService.getById(image.getResumeId());

        if(!resume.isSuccess()){
            return new ErrorResult(MessageResults.notFound(FIELD));
        }

        Image imageObject = new Image(
                resume.getData(),
                image.getImageUrl()
        );

        this.imageDao.save(imageObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }
}
