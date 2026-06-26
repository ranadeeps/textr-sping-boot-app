package com.textr.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
public class ChatRoomController {

    @GetMapping("/create-room")
    public String createRoom(){
        return UUID.randomUUID().toString();
    }
}
