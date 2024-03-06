package com.basic.kafka.consumer.kafka;

import com.basic.kafka.consumer.component.CommonComponent;
import com.basic.kafka.consumer.kafka.models.ReadUserInfo;
import com.basic.kafka.consumer.kafka.models.UserInfo;
import com.basic.kafka.consumer.service.CreateUserService;
import com.basic.kafka.consumer.service.DeleteUserService;
import com.basic.kafka.consumer.service.UpdateUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.basic.kafka.consumer.kafka.constant.KafkaConstant.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ManageUserConsumer {

    private final CreateUserService createUserService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;
    private final CommonComponent commonComponent;

    @KafkaListener(topics = CREATE_USER_INFO_TOPIC, groupId = "crud-kafka")
    public void createUserConsumer(Message<String> message) {
        String kafkaType = message.getHeaders().get(KAFKA_HEADER_TYPE, String.class);
        if (Objects.equals(kafkaType, KAFKA_HEADER_TYPE_VALUE_CREATE)) {
            UserInfo userInfo = commonComponent.convertJsonToObject(message.getPayload(), UserInfo.class);
            log.info("Consumer: create message :: {}", userInfo);
            createUserService.createUser(userInfo);
        }
    }

    @KafkaListener(topics = UPDATE_USER_INFO_TOPIC, groupId = "crud-kafka")
    public void updateUserConsumer(Message<String> message) {
        String kafkaType = message.getHeaders().get(KAFKA_HEADER_TYPE, String.class);
        if (Objects.equals(kafkaType, KAFKA_HEADER_TYPE_VALUE_UPDATE)) {
            UserInfo userInfo = commonComponent.convertJsonToObject(message.getPayload(), UserInfo.class);
            log.info("Consumer: update message :: {}", userInfo);
            updateUserService.updateUser(userInfo);
        }
    }

    @KafkaListener(topics = DELETE_USER_INFO_TOPIC, groupId = "crud-kafka")
    public void deleteUserConsumer(Message<String> message) {
        String kafkaType = message.getHeaders().get(KAFKA_HEADER_TYPE, String.class);
        if (Objects.equals(kafkaType, KAFKA_HEADER_TYPE_VALUE_DELETE)) {
            ReadUserInfo readUserInfo = commonComponent.convertJsonToObject(message.getPayload(), ReadUserInfo.class);
            log.info("Consumer: delete message :: {}", readUserInfo);
            deleteUserService.deleteUser(readUserInfo);
        }
    }
}