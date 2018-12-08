package ru.kpfu.itis.anochatty.service;

import ru.kpfu.itis.anochatty.dto.UserAuthDto;
import ru.kpfu.itis.anochatty.dto.UserSignUpForm;
import ru.kpfu.itis.anochatty.model.User;

public interface AuthService {
    User validateUserCredentials(UserAuthDto userAuthDto);

    User signUpUser(UserSignUpForm userSignUpForm);
}
