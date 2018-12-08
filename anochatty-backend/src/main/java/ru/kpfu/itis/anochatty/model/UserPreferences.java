package ru.kpfu.itis.anochatty.model;

import lombok.Data;

import java.util.List;

@Data
public class UserPreferences {
    private List<Long> movies;
    private List<Long> food;
    private List<Long> music;
}
