package com.basic.kafka.consumer.service;

import com.basic.kafka.consumer.kafka.models.UserInfo;
import com.basic.kafka.consumer.repository.UserInfoRepository;
import com.basic.kafka.consumer.repository.entity.UserInfoEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateUserService {

    private final UserInfoRepository userInfoRepository;

    public void createUser(UserInfo userInfo) {
        try{
            UserInfoEntity currentUser = userInfoRepository.findByEmail(userInfo.getEmail());
            if (currentUser == null) {
                UserInfoEntity userInfoEntity = UserInfoEntity.builder()
                        .firstname(userInfo.getFirstname())
                        .lastname(userInfo.getLastname())
                        .email(userInfo.getEmail())
                        .build();
                userInfoRepository.save(userInfoEntity);
                log.info("Create user info success");
            } else {
                throw new RuntimeException("User info has existing");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}