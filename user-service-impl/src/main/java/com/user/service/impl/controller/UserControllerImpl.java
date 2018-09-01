package com.user.service.impl.controller;

import com.user.serivce.api.controller.UserController;
import com.user.serivce.api.controller.model.UserLogin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserControllerImpl implements UserController {

    @Override
    public ResponseEntity<String> userLogin(@RequestBody UserLogin userLogin) {
        if (userLogin.getEmail().equals("dd@mail.com") && userLogin.getPassword().equals("1234")) {
            return ResponseEntity.ok().body("{\"succeed\": true}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\":\"Incorrect email or password\"}");
        }
    }
}
