package com.basic.kafka.consumer.service;

import com.basic.kafka.consumer.kafka.models.UserInfo;
import com.basic.kafka.consumer.repository.UserInfoRepository;
import com.basic.kafka.consumer.repository.entity.UserInfoEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateUserService {

    private final UserInfoRepository userInfoRepository;

    public void updateUser(UserInfo userInfo) {
        try {
            UserInfoEntity currentUser = userInfoRepository.findByEmail(userInfo.getEmail());
            if (currentUser != null) {
                currentUser.setFirstname(userInfo.getFirstname());
                currentUser.setLastname(userInfo.getLastname());
                currentUser.setUpdateDate(LocalDateTime.now());
                userInfoRepository.save(currentUser);
                log.info("Update user info success");
            } else {
                throw new RuntimeException("User info not found");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}