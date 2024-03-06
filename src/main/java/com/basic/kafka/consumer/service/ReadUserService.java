package com.basic.kafka.consumer.service;

import com.basic.kafka.consumer.kafka.models.ReadUserInfo;
import com.basic.kafka.consumer.kafka.models.UserInfo;
import com.basic.kafka.consumer.repository.UserInfoRepository;
import com.basic.kafka.consumer.repository.entity.UserInfoEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReadUserService {

    private final UserInfoRepository userInfoRepository;

    public ResponseEntity<UserInfo> readUser(ReadUserInfo readUserInfo) {
        UserInfo userInfo;
        try {
            UserInfoEntity userInfoEntity = userInfoRepository.findByEmail(readUserInfo.getEmail());
            if (userInfoEntity != null) {
                userInfo = UserInfo.builder()
                        .firstname(userInfoEntity.getFirstname())
                        .lastname(userInfoEntity.getLastname())
                        .email(userInfoEntity.getEmail())
                        .build();
                log.info("Read user info success");
            } else {
                throw new RuntimeException("Not found user info");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return ResponseEntity.ok().body(userInfo);
    }
}