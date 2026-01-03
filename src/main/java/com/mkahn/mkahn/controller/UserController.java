package com.mkahn.mkahn.controller;

import com.mkahn.mkahn.dto.UserDto;
import com.mkahn.mkahn.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Log4j2
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    private final UserService userService;

    @GetMapping(path = "/samples")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("OK");
    }

    @PostMapping(path= "/signUp")
    public Object create(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @PutMapping
    public Object update(@RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

    @GetMapping(path = "/{userId}")
    public Object get(@PathVariable Long userId) {
        return userService.get(userId);
    }

    @DeleteMapping(path = "/{userId}")
    public Object delete(@PathVariable Long userId) {
        return userService.delete(userId);
    }


    @GetMapping(path = "/list")
    public Object getList() {
        return userService.list();
    }

    @PostMapping(path= "/emailCheck")
    public boolean emailCheck(@RequestBody UserDto userDto) {
        return userService.emailCheck(userDto);
    }

    @PostMapping(path= "/nickNameCheck")
    public boolean nickNameCheck(@RequestBody UserDto userDto) {
        return userService.nickNameCheck(userDto);
    }

    @PostMapping(path= "/signIn")
    public UserDto signIn(@RequestBody UserDto userDto) {
        return userService.signIn(userDto);
    }
}