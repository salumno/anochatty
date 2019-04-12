package ru.kpfu.itis.anochatty.utils;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.anochatty.dto.RatedPreference;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class UserUtils {

    public String createSparseVector(final List<RatedPreference> ratedPreferences) {
        return ratedPreferences.stream()
                .map(ratedPreference -> String.valueOf(ratedPreference.getRating()))
                .collect(Collectors.joining(","));
    }
}
