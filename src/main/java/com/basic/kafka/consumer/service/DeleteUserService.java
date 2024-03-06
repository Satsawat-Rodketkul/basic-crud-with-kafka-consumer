package com.basic.kafka.consumer.service;

import com.basic.kafka.consumer.kafka.models.ReadUserInfo;
import com.basic.kafka.consumer.repository.UserInfoRepository;
import com.basic.kafka.consumer.repository.entity.UserInfoEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteUserService {

    private final UserInfoRepository userInfoRepository;

    public void deleteUser(ReadUserInfo readUserInfo) {
        try {
            UserInfoEntity currentUser = userInfoRepository.findByEmail(readUserInfo.getEmail());
            if (currentUser != null) {
                userInfoRepository.deleteByEmail(currentUser.getEmail());
                log.info("Delete user info success");
            } else {
                throw new RuntimeException("Not found user info");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}