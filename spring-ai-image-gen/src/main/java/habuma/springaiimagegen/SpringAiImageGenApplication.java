package habuma.springaiimagegen;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.zhipuai.ZhiPuAiImageModel;
import org.springframework.ai.zhipuai.api.ZhiPuAiImageApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiImageGenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiImageGenApplication.class, args);
    }

    @Bean
    ImageModel imageModel(@Value("${spring.ai.zhipuai.api-key}") String apiKey) {
        return new ZhiPuAiImageModel(new ZhiPuAiImageApi(apiKey));
    }

}
