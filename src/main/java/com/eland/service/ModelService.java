package com.eland.service;

import com.eland.dao.TrainDao;
import com.eland.pojo.TrainInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ModelService {
    @Autowired
    TrainDao trainDao;

    /**
     * 獲取車站名稱
     * @return 車站名稱list
     */
    public ArrayList<TrainInfo> getStationNameList(){
        return trainDao.selectStationName();
    }

    /**
     * 獲取列車資訊
     * @param trainInfoForUser
     * @return 列車資訊list
     */
    public ArrayList<TrainInfo> getTrainInfoList(TrainInfo trainInfoForUser){
        ArrayList<TrainInfo> trainInfoArrayList = trainDao.selectTrainInfo(trainInfoForUser);
        return trainInfoArrayList;
    }

}
