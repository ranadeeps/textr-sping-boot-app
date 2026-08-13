package com.textr.controllers;

import com.textr.models.Message;
import com.textr.models.MessageDTO;
import com.textr.services.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private ChatRoomService chatRoomService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/save-message")
    public ResponseEntity<Message> saveMessage(@RequestBody MessageDTO request) {
        return new ResponseEntity<>(chatRoomService.saveMessage(request.getRoomId(), request.getContent()), HttpStatus.CREATED);
    }

    @MessageMapping("/{roomId}")
    public void sendMessage(@DestinationVariable String roomId, @Payload MessageDTO message) {
        chatRoomService.saveMessage(roomId, message.getContent());
        String destinationTopic = "/room/" + roomId;
        messagingTemplate.convertAndSend(destinationTopic, message);
    }

    @MessageExceptionHandler
    public void handleException(Exception exception) {
        System.err.println("=== WEBSOCKET CONTROLLER ERROR ===");
        exception.printStackTrace();
    }
}
