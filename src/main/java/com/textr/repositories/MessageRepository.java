package com.textr.repositories;

import com.textr.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Override
    <S extends Message> S save(S message);
}
