package ru.kpfu.itis.anochatty.dto;

import lombok.Data;
import ru.kpfu.itis.anochatty.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDto {
    private Long id;
    private String nickname;

    private UserDto(final User user) {
        id = user.getId();
        nickname = user.getNickname();
    }

    public static UserDto from(final User user) {
        return new UserDto(user);
    }

    public static List<UserDto> from(final List<User> users) {
        return users.stream().map(UserDto::new).collect(Collectors.toList());
    }
}
