package ru.kpfu.itis.anochatty.dto;

import lombok.Data;
import ru.kpfu.itis.anochatty.model.UserPreferences;

@Data
public class UserSignUpForm {
    private String nickname;
    private String password;
    private UserPreferences userPreferences;
}
