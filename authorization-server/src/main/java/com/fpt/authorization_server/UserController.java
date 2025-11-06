package com.fpt.authorization_server;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserRepository userRepository;
    @GetMapping
    public List<UserDto> getUserByIdIn(List<Long> userId){
       return userRepository.findAllByIdIn(userId);
    }
}
