package com.teamviewer.calendarserver.controller;

import com.teamviewer.calendarserver.model.CalendarModel;
import com.teamviewer.calendarserver.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class ModelController {
    @Autowired
    private CalendarService calendarService;
    private CalendarModel calendarModel;

    @PostMapping("/create")
    public String addCalendar(@RequestBody CalendarModel calendarModel){
        calendarService.calCreate(calendarModel);
        return "ok";
    }

    @PostMapping("/delete")
    public String delCalendar(@RequestBody CalendarModel calendarModel){
        calendarService.calDelete(calendarModel);
        return "ok";
    }

    @GetMapping("/{roomId}")
    public List<CalendarModel> getCalendar(@PathVariable String roomId){
        List<CalendarModel> calendarModels=calendarService.getAllCal(roomId);
        return calendarModels;
    }

}
