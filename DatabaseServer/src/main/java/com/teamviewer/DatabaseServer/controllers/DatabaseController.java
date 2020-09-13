package com.teamviewer.DatabaseServer.controllers;


import com.teamviewer.DatabaseServer.model.request.DatabaseRequest;
import com.teamviewer.DatabaseServer.services.DatabaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/db")
@RestController
@Slf4j
public class DatabaseController {

    @Autowired
    DatabaseService dbservice;

    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String getquery(@RequestBody DatabaseRequest queryRequestModel){
        log.info("Get " + queryRequestModel.getRoomId() + "'s query : " + queryRequestModel.getQuery());
        dbservice.process(queryRequestModel);
        return "ok";
    }

}
