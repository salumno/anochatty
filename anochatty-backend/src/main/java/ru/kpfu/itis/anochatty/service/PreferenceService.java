package ru.kpfu.itis.anochatty.service;

import ru.kpfu.itis.anochatty.model.Food;
import ru.kpfu.itis.anochatty.model.Movie;
import ru.kpfu.itis.anochatty.model.Music;

import java.util.List;

public interface PreferenceService {
    List<Movie> getMovies();

    List<Food> getFood();

    List<Music> getMusic();
}
