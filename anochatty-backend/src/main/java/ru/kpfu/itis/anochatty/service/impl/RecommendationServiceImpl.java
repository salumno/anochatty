package ru.kpfu.itis.anochatty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.anochatty.model.User;
import ru.kpfu.itis.anochatty.repository.UserRepository;
import ru.kpfu.itis.anochatty.service.RecommendationService;
import ru.kpfu.itis.anochatty.utils.AnalysisServiceUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final UserRepository userRepository;
    private final AnalysisServiceUtils analysisServiceUtils;

    @Autowired
    public RecommendationServiceImpl(UserRepository userRepository, AnalysisServiceUtils analysisServiceUtils) {
        this.userRepository = userRepository;
        this.analysisServiceUtils = analysisServiceUtils;
    }

    @Override
    public List<User> getRecommendedUsers(Long userId) {
        List<Long> userIds = analysisServiceUtils.getRecommendedUserIds(userId);
        return userIds.stream()
                .map(userRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
