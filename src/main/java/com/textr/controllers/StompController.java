package com.textr.controllers;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class StompController {

    @MessageMapping("/to-room/{roomId}")
    public String handleMessage(@DestinationVariable String roomId) {
        return "Welcome to room " + roomId;
    }
}
