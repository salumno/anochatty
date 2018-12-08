package ru.kpfu.itis.anochatty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfiguration {
    public static final String DATA_ANALYSIS_SERVICE_HOST = "http://localhost";
    public static final String DATA_ANALYSIS_SERVICE_PORT = "8081";
    public static final String DATA_ANALYSIS_SERVICE_URL = DATA_ANALYSIS_SERVICE_HOST + ":" + DATA_ANALYSIS_SERVICE_PORT;


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
