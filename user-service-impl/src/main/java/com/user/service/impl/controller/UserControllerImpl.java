package com.user.service.impl.controller;

import com.user.serivce.api.controller.UserController;
import com.user.serivce.api.controller.model.UserLogin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserControllerImpl implements UserController {

    @Override
    public ResponseEntity<String> userLogin(UserLogin userLogin) {
        return ResponseEntity.status(HttpStatus.OK).body("mock it");
    }
}
