package com.teamviewer.calendarserver.services;

import com.teamviewer.calendarserver.model.CalendarModel;
import com.teamviewer.calendarserver.model.output.OutputCalendarModel;
import com.teamviewer.calendarserver.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {
    @Autowired
    private CalendarRepository calendarRepository;
    private CalendarModel calendarModel;

    public void calCreate(CalendarModel calendarModel) {
       calendarRepository.save(calendarModel);
    }

    public List<CalendarModel> getAllCal(String roomId) {
        List <CalendarModel> calendarModels=calendarRepository.findByRoomId(roomId);
        return calendarModels;
    }

    public String calDelete(CalendarModel calendarModel) {
        //calendarRepository.deleteByNum(calendarModel.getNum());
        return "ok";
    }
}
