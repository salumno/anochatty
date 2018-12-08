package ru.kpfu.itis.anochatty.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.anochatty.dto.UserDto;
import ru.kpfu.itis.anochatty.service.RecommendationService;

import java.util.List;

@RestController
public class RecommendationController {
    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @RequestMapping("/recommendation")
    public ResponseEntity<List<UserDto>> getRecommendedUsers(@RequestBody final Long userId) {
        return ResponseEntity.ok(UserDto.from(recommendationService.getRecommendedUsers(userId)));
    }
}
