package com.eland.controller;

import com.eland.pojo.bean.Timetable;
import com.eland.service.JsonToDbService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {
    JsonToDbService jsonToDbService = new JsonToDbService();
    @GetMapping("/Cent")
    public void centTask(){
        for(int i=0;i<5;i++){
            String date =jsonToDbService.getToday(i);
            ResponseEntity<Timetable[]> response = jsonToDbService.getTrainTimetable(date);

//            Timetable[] timetableArray = response.getBody();
        }

    }
    @GetMapping("/win")
    public void winServerTask(){
        for(int i=5;i<10;i++){
            String date =jsonToDbService.getToday(i);
            ResponseEntity<Timetable[]> response = jsonToDbService.getTrainTimetable(date);

//            Timetable[] timetableArray = response.getBody();
        }

    }


}
