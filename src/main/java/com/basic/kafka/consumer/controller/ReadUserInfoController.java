package com.basic.kafka.consumer.controller;

import com.basic.kafka.consumer.kafka.models.ReadUserInfo;
import com.basic.kafka.consumer.kafka.models.UserInfo;
import com.basic.kafka.consumer.service.ReadUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consumer/api/v1")
public class ReadUserInfoController {

    private final ReadUserService readUserService;

    @PostMapping("/read")
    public ResponseEntity<UserInfo> readUserInfo(@RequestBody ReadUserInfo readUserInfo) {
        return readUserService.readUser(readUserInfo);
    }
}