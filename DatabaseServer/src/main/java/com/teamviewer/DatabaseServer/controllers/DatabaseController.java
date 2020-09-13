package com.teamviewer.DatabaseServer.controllers;


import com.teamviewer.DatabaseServer.model.request.DatabaseRequest;
import com.teamviewer.DatabaseServer.services.DatabaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

@RequestMapping("/db")
@RestController
@Slf4j
public class DatabaseController {

    @Autowired
    DatabaseService dbservice;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public ArrayList<Map<String, String>> getquery(@RequestBody DatabaseRequest queryRequestModel) throws SQLException {
        log.info("Get " + queryRequestModel.getRoomId() + "'s query : " + queryRequestModel.getQuery());
//
//        Map<String, String> temp = dbservice.process(queryRequestModel);
//
//
//        for (String key : temp.keySet()) {
//            String value = temp.get(key);
//            System.out.println("[key]:" + key + ", [value]:" + value);
//        }
//
        return dbservice.process(queryRequestModel);
    }


}
