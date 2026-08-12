package com.textr.services;

import com.textr.models.ChatRoom;
import com.textr.models.Message;
import com.textr.repositories.ChatRoomRepository;
import com.textr.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @Autowired
    private MessageRepository messageRepository;

    public String createRoom() {
        String roomId = generateValidRoomId();
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setRoomId(roomId);
        chatRoomRepository.save(chatRoom);
        return roomId;
    }

    public String generateValidRoomId() {
        String roomId;

        boolean isDuplicate = false;
        do {
            roomId = UUID.randomUUID().toString();
            isDuplicate = chatRoomRepository.existsByRoomId(roomId);
        } while (isDuplicate);
        return roomId;
    }

    public Message saveMessage(String roomId, String content) {
        ChatRoom chatRoom = chatRoomRepository.findByRoomId(roomId);
        Message message = new Message();
        message.setContent(content);
        message.setChatRoom(chatRoom);
        return messageRepository.save(message);
    }

    public List<Message> getMessages(String roomId){
        ChatRoom chatRoom = chatRoomRepository.findByRoomId(roomId);
        return chatRoom.getMessages();
    }
}
