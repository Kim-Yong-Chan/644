package com.teamviewer.chatserver.services;

import com.teamviewer.chatserver.model.ChatModel;
import com.teamviewer.chatserver.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    public void chatInput(ChatModel chatModelInput){
        ChatModel chatModel=new ChatModel(chatModelInput.getRoomId(),chatModelInput.getUserId(),chatModelInput.getChatStr());
                //chatModelInput.getChatTimestamp());
        chatRepository.save(chatModel);
    }

    //exception handling 필요
    public Optional<ChatModel> findByRoomId(String roomId){
        return chatRepository.findByRoomId(roomId);
    }


}
