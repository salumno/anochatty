package ru.kpfu.itis.anochatty.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.anochatty.model.Food;
import ru.kpfu.itis.anochatty.model.Movie;
import ru.kpfu.itis.anochatty.model.Music;
import ru.kpfu.itis.anochatty.service.PreferenceService;

import java.util.List;

import static ru.kpfu.itis.anochatty.config.WebConfiguration.FRONTEND_SERVICE_URL;

@RestController
@RequestMapping("/preferences")
@CrossOrigin(origins = FRONTEND_SERVICE_URL)
public class PreferencesController {

    private PreferenceService preferenceService;

    @Autowired
    public PreferencesController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(preferenceService.getMovies());
    }

    @GetMapping("/food")
    public ResponseEntity<List<Food>> getFood() {
        return ResponseEntity.ok(preferenceService.getFood());
    }

    @GetMapping("/music")
    public ResponseEntity<List<Music>> getMusic() {
        return ResponseEntity.ok(preferenceService.getMusic());
    }
}
