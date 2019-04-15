package ru.kpfu.itis.anochatty.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PreferenceUpdateDto {
    @NotNull
    private Long userID;
    @NotNull
    private String text;
}
