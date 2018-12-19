package ru.kpfu.itis.anochatty.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.anochatty.dto.UserDto;
import ru.kpfu.itis.anochatty.dto.UserIdDto;
import ru.kpfu.itis.anochatty.service.RecommendationService;

import javax.validation.Valid;
import java.util.List;

import static ru.kpfu.itis.anochatty.config.WebConfiguration.FRONTEND_SERVICE_URL;

@RestController
@RequestMapping("/recommendation")
@CrossOrigin(origins = FRONTEND_SERVICE_URL)
public class RecommendationController {
    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("")
    public ResponseEntity<List<UserDto>> getRecommendedUsers(@Valid  @RequestBody final UserIdDto userIdDto) {
        return ResponseEntity.ok(UserDto.from(recommendationService.getRecommendedUsers(userIdDto.getUserID())));
    }
}
