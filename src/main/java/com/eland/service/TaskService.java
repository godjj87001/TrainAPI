package com.eland.service;

import com.eland.dao.TrainDao;
import com.eland.pojo.Timetable;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import static com.eland.pojo.DbMessage.dbMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class TaskService {
    //每次調用方法重置message為"" ，並抓取後面的e.get message (Exception)
    @Autowired
    TrainDao trainDao;
    @Value("${urlApi}")
    String urlApi;
    @Value("${replaceUrlApi}")
    String replaceUrlApi;

    public void getTrainTimetable(String date) {
        if (urlApi != null || urlApi.contains("<date>")) {
            replaceUrlApi = urlApi.replace("<date>", date);
        } else {
            return;
        }

        Timetable[] timetableArr = callTrainApi();
        if (timetableArr == null) return;
        insertDate(timetableArr);
    }

    /**
     * call 台鐵API
     *
     * @return Array timetableArr
     */
    private Timetable[] callTrainApi() {
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        BufferedReader reader;
        StringBuilder result;
        String line;
        try {
            // 使用Apache HttpClient發送HTTP請求
            client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(replaceUrlApi);
            httpGet.addHeader("Accept-Charset", "UTF-8");
            httpGet.setHeader("Authorization", authList().get(0));
            httpGet.setHeader("x-date", authList().get(1));
            response = client.execute(httpGet);

            // 從HTTP中獲取返回的字符串
            reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
            result = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            // 將字符串轉換為Java對象
            ObjectMapper mapper = new ObjectMapper();
            //導入Pojo的Timetable[]
            Timetable[] timetableArr = mapper.readValue(result.toString(), Timetable[].class);

            return timetableArr;
        } catch (IOException e) {
            e.printStackTrace();
            dbMessage = dbMessage + ",IOException";
        } catch (Exception e) {
            e.printStackTrace();
            dbMessage = dbMessage + ",Exception";
        } finally {
            // 關閉連接
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    /**
     * 將Json解析的JAVA物件寫入資料庫
     *
     * @param timetableArr
     */
    private void insertDate(Timetable[] timetableArr) {
        //寫入資料
        for (Timetable timetable : timetableArr) {
            //Table DailyTrainInfo
            trainDao.replaceTrainStationDailyTrainInfo(timetable);
            //Table StopTimes
            trainDao.repalceTrainStationStopTimes(timetable);
        }
    }

    /**
     * 取回包含今天到後十天的日期
     *
     * @return list
     */
    public ArrayList<String> dateList() {
        LocalDate nowDate = LocalDate.now();
        ArrayList<String> dateList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            dateList.add(i, nowDate.plusDays(i).toString());
        }
        return dateList;
    }

    /**
     * 取得台鐵ServerTime做驗證用
     */
    public static String getServerTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(calendar.getTime());
    }

    /**
     * 台鐵提供的驗證
     *
     * @return get(0)=sAuth
     * get(1)=x-date
     */
    ArrayList<String> authList() {
        ArrayList<String> auth = new ArrayList<>();
        // 申請的APPID
        // （FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF 為 Guest
        // 帳號，以IP作為API呼叫限制，請替換為註冊的APPID & APPKey）
        String APPID = "FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF";
        // 申請的APPKey
        String APPKey = "FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF";
        // 取得當下的UTC時間，Java8有提供時間格式DateTimeFormatter.RFC_1123_DATE_TIME
        // 但是格式與C#有一點不同，所以只能自行定義
        String xdate = getServerTime();
        String SignDate = "x-date: " + xdate;
        String hmacSha1Signature = "";
        try {
            // 取得加密簽章
            hmacSha1Signature = hmacSha1Signature(SignDate, APPKey);
        } catch (SignatureException e1) {
            dbMessage = dbMessage + "hmacSha1SignatureException";
            e1.printStackTrace();
        }
        //台鐵提供的身分驗證
        String sAuth = "hmac username=\"" + APPID + "\", algorithm=\"hmac-sha1\", headers=\"x-date\", signature=\""
                + hmacSha1Signature + "\"";
        auth.add(0, sAuth);
        auth.add(1, xdate);
        return auth;
    }

    /**
     * @param xData  台鐵驗證用的伺服器時間
     * @param AppKey 台鐵驗證用的遊客APPKEY
     * @return hmacSha1加密的字串
     */
    public String hmacSha1Signature(String xData, String AppKey) throws java.security.SignatureException {
        try {
            final Base64.Encoder encoder = Base64.getEncoder();
            // get a Hmac_sha1 key from the raw key bytes
            SecretKeySpec signingKey = new SecretKeySpec(AppKey.getBytes(StandardCharsets.UTF_8), "HmacSHA1");
            // get a hmac_sha1 Mac instance and initialize with the signing key
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            // compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(xData.getBytes(StandardCharsets.UTF_8));
            String result = encoder.encodeToString(rawHmac);
            return result;
        } catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
    }
}
