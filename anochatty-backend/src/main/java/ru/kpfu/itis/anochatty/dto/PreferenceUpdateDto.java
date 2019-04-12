package ru.kpfu.itis.anochatty.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PreferenceUpdateDto {
    @NotNull
    private Long userId;
    @NotEmpty
    private String messages;
}
