package ru.kpfu.itis.anochatty.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.anochatty.model.Preference;
import ru.kpfu.itis.anochatty.service.PreferenceService;

import java.util.List;

@RestController
@RequestMapping("/preferences")
@CrossOrigin
public class PreferencesController {

    private PreferenceService preferenceService;

    @Autowired
    public PreferencesController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

    @GetMapping
    public ResponseEntity<List<Preference>> getPreferences() {
        return ResponseEntity.ok(preferenceService.getPreferences());
    }
}
