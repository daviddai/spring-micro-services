package com.user.serivce.api.controller;

import com.user.serivce.api.controller.model.UserLogin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public interface UserController {

    @PostMapping(path = "/login")
    ResponseEntity<String> userLogin(@RequestBody UserLogin userLogin);

}
