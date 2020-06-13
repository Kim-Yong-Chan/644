package com.teamviewer.calendarserver.controller;

import com.teamviewer.calendarserver.model.CalendarModel;
import com.teamviewer.calendarserver.model.output.OutputCalendarModel;
import com.teamviewer.calendarserver.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    @PostMapping("/create")
    public String addCalendar(@RequestBody CalendarModel calendarModel){
        calendarService.calCreate(calendarModel);
        return "ok";
    }

    @PostMapping("/delete/{num}")
    public String delCalendar(@PathVariable int num){
        calendarService.calDelete(num);
        return "ok";
    }

    @GetMapping("/{roomId}")
    public List<OutputCalendarModel> getCalendar(@PathVariable String roomId){
        List<OutputCalendarModel> outputCalendarModels=calendarService.getAllCal(roomId);
        return outputCalendarModels;
    }

}
