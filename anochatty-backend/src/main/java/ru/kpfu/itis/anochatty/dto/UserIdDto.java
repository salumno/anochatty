package ru.kpfu.itis.anochatty.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserIdDto {
    @NotNull
    private Long userID;
}
