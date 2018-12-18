package ru.kpfu.itis.anochatty.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.anochatty.config.WebConfiguration;
import ru.kpfu.itis.anochatty.dto.RemoteServerResponse;
import ru.kpfu.itis.anochatty.dto.UserIdDto;

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
        data.setVector(sparseVector);
        data.setUserID(userId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final HttpEntity<DataAnalysisServiceUserDto> request = new HttpEntity<>(data, headers);
        restTemplate.postForEntity(WebConfiguration.DATA_ANALYSIS_SERVICE_URL + "/sign-up", request, RemoteServerResponse.class);
    }

    public List<Long> getRecommendedUserIds(final Long userId) {
        final UserIdDto userIdDto = new UserIdDto();
        userIdDto.setUserID(userId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserIdDto> request = new HttpEntity<>(userIdDto, headers);
//        ResponseEntity<RemoteServerResponse> responseEntityWithIds = restTemplate.postForEntity(WebConfiguration.DATA_ANALYSIS_SERVICE_URL + "/recommend", request, RemoteServerResponse.class);

//        final String ids = responseEntityWithIds.hasBody() ? responseEntityWithIds.getBody().getUserIDs() : "";
        final String mockId = "1";
        return Stream.of(mockId.split(","))
                .map(Long::valueOf)
                .collect(Collectors.toList());
    }

    @Data
    private class DataAnalysisServiceUserDto {
        private Long userID;
        private String vector;
    }
}
