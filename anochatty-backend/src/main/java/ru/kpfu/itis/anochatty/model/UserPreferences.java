package ru.kpfu.itis.anochatty.model;

import lombok.Data;
import ru.kpfu.itis.anochatty.dto.FoodDto;
import ru.kpfu.itis.anochatty.dto.MovieDto;
import ru.kpfu.itis.anochatty.dto.MusicDto;

import java.util.List;

@Data
public class UserPreferences {
    private List<MovieDto> movies;
    private List<FoodDto> food;
    private List<MusicDto> music;
}
