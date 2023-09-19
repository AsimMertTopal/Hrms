package Hrms.core.utilities;

import java.io.File;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PhotoUploadService {
    private final CloudinaryConfigration cloudinaryConfigration;

    public PhotoUploadService(CloudinaryConfigration cloudinaryConfigration) {
        this.cloudinaryConfigration = cloudinaryConfigration;
    }

    public Map<String, String> uploadPhoto(File photoFile) {
        return cloudinaryConfigration.uploadFile(photoFile);
    }
}
