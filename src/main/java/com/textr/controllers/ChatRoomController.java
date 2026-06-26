package com.textr.controllers;

import com.textr.models.Message;
import com.textr.services.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    @GetMapping("")
    public String helloWorld() {
        return "hello world from chat room controller";
    }

    @GetMapping("/create-room")
    public String createRoom() {
        return chatRoomService.createRoom();
    }

    @GetMapping("/get-messages/{roomId}")
    public ResponseEntity<List<Message>> getMessages(@PathVariable String roomId){
        return  new ResponseEntity<>(chatRoomService.getMessages(roomId), HttpStatus.ACCEPTED);
    }

}
