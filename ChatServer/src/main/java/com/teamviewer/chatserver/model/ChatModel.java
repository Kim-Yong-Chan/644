package com.teamviewer.chatserver.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="chat")
@Getter
@Setter
public class ChatModel {
    @Id
    private int num;
    @Column
    private String roomId;
    @Column
    private String userId;
    @Column
    private String chatStr;
    /*
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private java.util.Date chatTimestamp;
    */
    public ChatModel(){

    }
    public ChatModel(String roomId,String userId,String chatStr){//java.util.Date chatTimestamp){
        this.roomId=roomId;
        this.userId=userId;
        this.chatStr=chatStr;
        //this.chatTimestamp=chatTimestamp;
    }
}
