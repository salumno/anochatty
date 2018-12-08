package ru.kpfu.itis.anochatty.service;

import ru.kpfu.itis.anochatty.model.User;

import java.util.List;

public interface RecommendationService {
    List<User> getRecommendedUsers(Long userId);
}
