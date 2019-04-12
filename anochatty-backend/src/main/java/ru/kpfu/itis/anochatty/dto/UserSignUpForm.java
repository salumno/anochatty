package ru.kpfu.itis.anochatty.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserSignUpForm {
    private String nickname;
    private String password;
    private List<RatedPreference> ratedPreferences;
}
