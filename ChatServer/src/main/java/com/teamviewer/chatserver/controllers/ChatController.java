package com.teamviewer.chatserver.controllers;

import com.teamviewer.chatserver.model.ChatModel;
import com.teamviewer.chatserver.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/")
    public String addChat(@RequestBody ChatModel chatModel){
        chatService.chatInput(chatModel);
        return "ok";
    }

    @GetMapping("/{roomId}")
    public String getChat(@PathVariable String roomId){
        chatService.findByRoomId(roomId);
        return "ok";
    }
}
