package ru.kpfu.itis.anochatty.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.anochatty.model.Preference;
import ru.kpfu.itis.anochatty.repository.PreferenceRepository;
import ru.kpfu.itis.anochatty.service.PreferenceService;

import java.util.List;

@Service
public class PreferenceServiceImpl implements PreferenceService {
    private final PreferenceRepository preferenceRepository;

    public PreferenceServiceImpl(PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public List<Preference> getPreferences() {
        return preferenceRepository.findAll();
    }
}
