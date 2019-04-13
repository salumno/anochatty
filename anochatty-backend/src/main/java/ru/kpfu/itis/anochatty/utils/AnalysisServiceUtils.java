package ru.kpfu.itis.anochatty.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.anochatty.dto.PreferenceUpdateDto;
import ru.kpfu.itis.anochatty.dto.RemoteServerResponse;

import java.util.Collections;
import java.util.List;

import static ru.kpfu.itis.anochatty.config.WebConfiguration.DATA_ANALYSIS_SERVICE_URL;

@Component
public class AnalysisServiceUtils {

    private RestTemplate restTemplate;

    @Autowired
    public AnalysisServiceUtils(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendUserDataToService(final Long userId, final String sparseVector) {
        final DataAnalysisServiceUserDto data = new DataAnalysisServiceUserDto();
        data.setVector(sparseVector);
        data.setUserID(userId);

        final HttpEntity<DataAnalysisServiceUserDto> request = new HttpEntity<>(data, getHttpHeaderJson());
        restTemplate.postForEntity(DATA_ANALYSIS_SERVICE_URL + "/sign-up", request, RemoteServerResponse.class);
    }

    public List<Long> getRecommendedUserIds(final Long userId) {
        if (userId == 1) {
            return Collections.singletonList(2L);
        } else if (userId == 2) {
            return Collections.singletonList(1L);
        }
        return Collections.emptyList();
    }

    public void sendUserMessagesToAnalyze(final PreferenceUpdateDto preferenceUpdateDto) {
        HttpEntity<PreferenceUpdateDto> request = new HttpEntity<>(preferenceUpdateDto, getHttpHeaderJson());
        System.out.println(preferenceUpdateDto.getUserId() + ": " + preferenceUpdateDto.getMessages());
    }

    private HttpHeaders getHttpHeaderJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @Data
    private class DataAnalysisServiceUserDto {
        private Long userID;
        private String vector;
    }
}
