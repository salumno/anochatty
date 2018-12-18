package ru.kpfu.itis.anochatty.dto;

import lombok.Data;

@Data
public class RemoteServerResponse {
    private boolean success;
    private String userIDs;
}
