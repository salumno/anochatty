package ru.kpfu.itis.anochatty.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.anochatty.WebConfiguration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class AnalysisServiceUtils {

    private RestTemplate restTemplate;

    @Autowired
    public AnalysisServiceUtils(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendUserDataToService(final Long userId, final String sparseVector) {
        final DataAnalysisServiceUserDto data = new DataAnalysisServiceUserDto();
        data.setSparseVector(sparseVector);
        data.setUserId(userId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final HttpEntity<DataAnalysisServiceUserDto> request = new HttpEntity<>(data, headers);
        restTemplate.postForEntity(WebConfiguration.DATA_ANALYSIS_SERVICE_URL + "/sign-up", request, String.class);
    }

    public List<Long> getRecommendedUserIds(final Long userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, Long> map = new LinkedMultiValueMap<>();
        map.add("userId", userId);

        HttpEntity<MultiValueMap<String, Long>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> responseEntityWithIds = restTemplate.postForEntity(WebConfiguration.DATA_ANALYSIS_SERVICE_URL + "/recommend", request, String.class);

        final String ids = responseEntityWithIds.hasBody() ? responseEntityWithIds.getBody() : "";
        return Stream.of(ids.split(","))
                .map(Long::valueOf)
                .collect(Collectors.toList());
    }

    @Data
    private class DataAnalysisServiceUserDto {
        private Long userId;
        private String sparseVector;
    }
}
