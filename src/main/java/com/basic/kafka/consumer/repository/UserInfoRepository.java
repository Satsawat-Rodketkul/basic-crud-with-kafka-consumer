package com.basic.kafka.consumer.repository;

import com.basic.kafka.consumer.repository.entity.UserInfoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer> {

    UserInfoEntity findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}