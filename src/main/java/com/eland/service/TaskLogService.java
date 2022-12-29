package com.eland.service;

import com.eland.dao.TrainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static com.eland.pojo.DbMessage.dbMessage;

@Service
public class TaskLogService {
    @Autowired
    public TrainDao trainDao;

    /**
     * insert train_task_log
     */
    public void writeLog() {
        String machineName = getServerName();
        //新增現在時間
        String updateTime = nowDate() + " " + nowTime();
        //寫入log資料庫
        trainDao.insertLog(machineName, updateTime, dbMessage);
    }

    /**
     * 獲取電腦名稱
     * @return電腦名稱
     */
    String getServerName() {
        String serverName = "";
        try {
            // 獲取本地電腦名稱
            serverName = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serverName;
    }

    /**
     * 現在日期 用於回傳寫入LOG資料庫日期
     * @return
     */
    String nowDate() {
        LocalDate nowDate = LocalDate.now();
        return nowDate.toString();
    }

    /**
     * 現在時間 用於回傳寫入LOG資料庫時間
     * @return
     */
    String nowTime() {
        LocalTime nowTime = LocalTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        return dtf.format(nowTime);
    }
}
