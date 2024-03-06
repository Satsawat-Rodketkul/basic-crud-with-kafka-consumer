package com.basic.kafka.consumer.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_info_kafka_crud")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    @PrePersist
    private void autoCreate() {
        createDate = LocalDateTime.now();
        updateDate = LocalDateTime.now();
    }
}