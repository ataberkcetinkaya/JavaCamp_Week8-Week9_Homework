package coding.hrms.core.adapters.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import coding.hrms.business.constants.MessageResults;
import coding.hrms.core.adapters.abstracts.PictureUploadService;
import coding.hrms.core.utilities.results.DataResult;
import coding.hrms.core.utilities.results.ErrorDataResult;
import coding.hrms.core.utilities.results.SuccessDataResult;

public class CloudinaryServiceAdapter implements PictureUploadService {

    private final Cloudinary cloudinary;
    private final Map<String, String> config = new HashMap<>();

    public CloudinaryServiceAdapter(){
        config.put("cloud_name", "");
        config.put("api_key", "");
        config.put("api_secret", "");
        cloudinary = new Cloudinary();
    }

    public DataResult<Map<String, String>> upload(MultipartFile multiPartFile) {
        File file;

        try{
            file = convert(multiPartFile);
            Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return new SuccessDataResult<Map<String, String>>(result);
        }
        catch (IOException exception){
            exception.printStackTrace();
            return new ErrorDataResult<Map<String, String>>(MessageResults.errorWhileUploadingFile);
        }
    }

    public DataResult<Map> delete (String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
        return new SuccessDataResult<Map>(result);
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();
        return file;
    }
}
