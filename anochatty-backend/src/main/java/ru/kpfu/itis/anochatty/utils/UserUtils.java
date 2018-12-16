package ru.kpfu.itis.anochatty.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.anochatty.dto.PreferenceDto;
import ru.kpfu.itis.anochatty.model.Preference;
import ru.kpfu.itis.anochatty.model.UserPreferences;
import ru.kpfu.itis.anochatty.repository.FoodRepository;
import ru.kpfu.itis.anochatty.repository.MovieRepository;
import ru.kpfu.itis.anochatty.repository.MusicRepository;

import java.util.List;


@Component
public class UserUtils {
    private final MovieRepository movieRepository;
    private final FoodRepository foodRepository;
    private final MusicRepository musicRepository;

    public UserUtils(MovieRepository movieRepository, FoodRepository foodRepository, MusicRepository musicRepository) {
        this.movieRepository = movieRepository;
        this.foodRepository = foodRepository;
        this.musicRepository = musicRepository;
    }

    public String createSparseVector(final UserPreferences userPreferences) {
        String movieSparseVector = getPreferenceSparseVector(userPreferences.getMovies(), movieRepository);
        String foodSparseVector = getPreferenceSparseVector(userPreferences.getFood(), foodRepository);
        String musicSparseVector = getPreferenceSparseVector(userPreferences.getMusic(), musicRepository);
        return movieSparseVector + foodSparseVector + musicSparseVector;
    }

    private String getPreferenceSparseVector(
            final List<? extends PreferenceDto> preferences,
            final JpaRepository<? extends Preference, Long> preferenceRepository) {
        final StringBuilder sparseVector = new StringBuilder();
        preferenceRepository.findAll().forEach(preference -> {
            final Long id = preference.getId();
            final Integer currentPreferenceRating = preferences.stream()
                    .filter(preferenceDto -> preferenceDto.getId().equals(id))
                    .findFirst()
                    .map(PreferenceDto::getRating)
                    .orElseThrow(
                            () -> new IllegalArgumentException("Preference with id " + id + " not found.")
                    );
            sparseVector.append(currentPreferenceRating);
        });
        return sparseVector.toString();
    }
}
