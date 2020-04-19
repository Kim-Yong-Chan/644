package com.teamviewer.chatserver.controllers;

import com.teamviewer.chatserver.model.ChatModel;
import com.teamviewer.chatserver.model.Input.InputChatModel;
import com.teamviewer.chatserver.model.Output.OutputChatModel;
import com.teamviewer.chatserver.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/")
    public String addChat(@RequestBody InputChatModel inputChatModel){
        chatService.chatInput(inputChatModel);
        return "ok";
    }

    @GetMapping("/{roomId}")
    public List<OutputChatModel> getChat(@PathVariable String roomId){
        List<OutputChatModel> outputChatModels = chatService.getAllChat(roomId);
        return outputChatModels;
    }
}
