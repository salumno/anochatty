package ru.kpfu.itis.anochatty.model;

import lombok.Data;

import java.util.List;

@Data
public class UserPreferences {
    private List<Movie> movies;
    private List<Food> food;
    private List<Music> music;
}
