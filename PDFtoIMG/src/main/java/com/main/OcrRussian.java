package com.main;

import com.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class OcrRussian {

    public static void main(String[] args) throws IOException {
        String host = "https://ruassian.market.alicloudapi.com";
        String path = "/ocrservice/russian";
        String method = "POST";
        String appcode = "你自己的AppCode";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE
        headers.put("Authorization", "APPCODE " + "");
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        String imgPath = "C:\\Users\\dhgk\\Desktop\\3.jpg";
        byte[] imageBytes = Files.readAllBytes(Paths.get(imgPath));
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        String bodys = "{\"url\":\"https://hdgkdzwl.oss-cn-hangzhou.aliyuncs.com/businessCard/2c5587d6-a0e8-48d7-8953-b5da53ffec08.jpg\",\"prob\":false,\"charInfo\":false,\"rotate\":false,}";

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */

            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            // 获取响应体
            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println("Response Body: " + responseBody);

            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
