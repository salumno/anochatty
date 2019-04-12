package ru.kpfu.itis.anochatty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.anochatty.dto.UserAuthDto;
import ru.kpfu.itis.anochatty.dto.UserSignUpForm;
import ru.kpfu.itis.anochatty.model.User;
import ru.kpfu.itis.anochatty.repository.UserRepository;
import ru.kpfu.itis.anochatty.service.AuthService;
import ru.kpfu.itis.anochatty.utils.AnalysisServiceUtils;
import ru.kpfu.itis.anochatty.utils.UserUtils;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserUtils userUtils;
    private final AnalysisServiceUtils analysisServiceUtils;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, UserUtils userUtils, AnalysisServiceUtils analysisServiceUtils) {
        this.userRepository = userRepository;
        this.userUtils = userUtils;
        this.analysisServiceUtils = analysisServiceUtils;
    }

    @Override
    public User validateUserCredentials(UserAuthDto userAuthDto) {
        final User user = userRepository.findByNickname(userAuthDto.getNickname())
                .orElseThrow(
                        () -> new IllegalArgumentException("User is not found by nickname: " + userAuthDto.getNickname())
                );
        return user.getPassword().equals(userAuthDto.getPassword()) ? user : null;
    }

    @Override
    public User signUpUser(UserSignUpForm userSignUpForm) {
        final Optional<User> optionalUser = userRepository.findByNickname(userSignUpForm.getNickname());
        if (optionalUser.isPresent()) {
            throw new IllegalArgumentException("User with nickname: " + userSignUpForm.getNickname() + " is already exist");
        }
        final User user = new User();
        user.setNickname(userSignUpForm.getNickname());
        user.setPassword(userSignUpForm.getPassword());
        userRepository.save(user);
        analysisServiceUtils.sendUserDataToService(user.getId(), userUtils.createSparseVector(userSignUpForm.getRatedPreferences()));
        return user;
    }
}
