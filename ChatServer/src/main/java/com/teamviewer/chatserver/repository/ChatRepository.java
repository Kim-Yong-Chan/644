package com.teamviewer.chatserver.repository;

import com.teamviewer.chatserver.model.ChatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<ChatModel,String> {
    public Optional<ChatModel> findByRoomId(String roomId);
}
