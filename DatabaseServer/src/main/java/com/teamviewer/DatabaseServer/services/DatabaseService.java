package com.teamviewer.DatabaseServer.services;


import com.teamviewer.DatabaseServer.model.request.DatabaseRequest;
import com.teamviewer.DatabaseServer.repository.DatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    //@Autowired
    //DatabaseRepository databaseRepository;

    public String process(DatabaseRequest databasemodel){
        //databasemodel에 roomid, query를 getRoomId(), getQuery()로 가져다쓴다
        return "여기에 query 결과 return?";
    }
}
