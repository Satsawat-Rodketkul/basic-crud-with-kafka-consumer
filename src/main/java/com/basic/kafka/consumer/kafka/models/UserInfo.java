package com.basic.kafka.consumer.kafka.models;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String firstname;
    private String lastname;
    private String email;
}