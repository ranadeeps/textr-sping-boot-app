package com.textr.controllers;

import com.textr.models.Message;
import com.textr.models.MessageDTO;
import com.textr.services.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private ChatRoomService chatRoomService;

    @PostMapping("/save-message")
    public ResponseEntity<Message> saveMessage(@RequestBody MessageDTO request) {
        return new ResponseEntity<>(chatRoomService.saveMessage(request.getRoomId(), request.getContent()), HttpStatus.CREATED);
    }

    @MessageMapping("/{roomId}")
    @SendTo("/room/{roomId}")
    public String sendMessage(@DestinationVariable String roomId, @Payload String message) {
        chatRoomService.saveMessage(roomId, message);
        return message;
    }

}
