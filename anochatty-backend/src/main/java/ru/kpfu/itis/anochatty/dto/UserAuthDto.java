package ru.kpfu.itis.anochatty.dto;

import lombok.Data;

@Data
public class UserAuthDto {
    private String nickname;
    private String password;
}
