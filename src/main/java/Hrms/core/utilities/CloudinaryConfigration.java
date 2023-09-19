package Hrms.core.utilities;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfigration {
    private final String CLOUD_NAME = "dppzorj2x";
    private final String API_KEY = "785289859567612";
    private final String API_SECRET = "4v0M7WyUu3GnM5DuDAdafQBbOWY";

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", CLOUD_NAME);
        config.put("api_key", API_KEY);
        config.put("api_secret", API_SECRET);

        return new Cloudinary(config);
    }

	public Map<String, String> uploadFile(File photoFile) {
		
		return null;
	}
}
