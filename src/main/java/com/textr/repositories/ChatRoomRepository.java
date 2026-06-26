package com.textr.repositories;

import com.textr.models.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    <S extends ChatRoom> S save(S chatRoom);

    boolean existsByRoomId(String roomId);

    ChatRoom findByRoomId(String roomId);
}
