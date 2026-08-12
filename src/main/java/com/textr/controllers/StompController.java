package com.textr.controllers;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class StompController {

    @MessageMapping("/default")
    public String handleDefaultMessage(@DestinationVariable String roomId) {
        return "Welcome to room " + roomId;
    }
}
