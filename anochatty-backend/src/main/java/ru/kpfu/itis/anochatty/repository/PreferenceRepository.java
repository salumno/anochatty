package ru.kpfu.itis.anochatty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.anochatty.model.Preference;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {
}
