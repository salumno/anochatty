package ru.kpfu.itis.anochatty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfiguration {
    public static final String DATA_ANALYSIS_SERVICE_HOST = "http://10.17.2.49";
    public static final String DATA_ANALYSIS_SERVICE_PORT = "5000";
    public static final String DATA_ANALYSIS_SERVICE_URL = DATA_ANALYSIS_SERVICE_HOST + ":" + DATA_ANALYSIS_SERVICE_PORT;

    public static final String FRONTEND_SERVICE_HOST = "http://localhost";
    public static final String FRONTEND_SERVICE_PORT = "4200";
    public static final String FRONTEND_SERVICE_URL = FRONTEND_SERVICE_HOST + ":" + FRONTEND_SERVICE_PORT;


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
