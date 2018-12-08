package ru.kpfu.itis.anochatty.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.anochatty.model.Food;
import ru.kpfu.itis.anochatty.model.Movie;
import ru.kpfu.itis.anochatty.model.Music;
import ru.kpfu.itis.anochatty.repository.FoodRepository;
import ru.kpfu.itis.anochatty.repository.MovieRepository;
import ru.kpfu.itis.anochatty.repository.MusicRepository;
import ru.kpfu.itis.anochatty.service.PreferenceService;

import java.util.List;

@Service
public class PreferenceServiceImpl implements PreferenceService {
    private final MusicRepository musicRepository;
    private final FoodRepository foodRepository;
    private final MovieRepository movieRepository;

    public PreferenceServiceImpl(MusicRepository musicRepository, FoodRepository foodRepository, MovieRepository movieRepository) {
        this.musicRepository = musicRepository;
        this.foodRepository = foodRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Food> getFood() {
        return foodRepository.findAll();
    }

    @Override
    public List<Music> getMusic() {
        return musicRepository.findAll();
    }
}
