package ru.kpfu.itis.anochatty.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.anochatty.dto.UserAuthDto;
import ru.kpfu.itis.anochatty.dto.UserDto;
import ru.kpfu.itis.anochatty.dto.UserSignUpForm;
import ru.kpfu.itis.anochatty.model.User;
import ru.kpfu.itis.anochatty.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<UserDto> signIn(@RequestBody final UserAuthDto userAuthDto) {
        final User user = authService.validateUserCredentials(userAuthDto);
        return user == null ? ResponseEntity.status(HttpStatus.UNAUTHORIZED).build() : ResponseEntity.ok(UserDto.from(user));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserDto> signUp(@RequestBody final UserSignUpForm userSignUpForm) {
        final User user = authService.signUpUser(userSignUpForm);
        return ResponseEntity.ok(UserDto.from(user));
    }
}
