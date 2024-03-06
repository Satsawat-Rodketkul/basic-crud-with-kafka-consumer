package com.basic.kafka.consumer.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class CommonComponent {

    @SneakyThrows
    public String convertObjectToJson(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(o);
    }

    @SneakyThrows
    public <T> T convertJsonToObject(String s, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(s, clazz);
    }
}