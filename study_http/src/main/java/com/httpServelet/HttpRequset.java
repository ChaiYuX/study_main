package com.httpServelet;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/**
 *GET / HTTP/1.1
 * Host: localhost:8080
 * Connection: keep-alive
 * sec-ch-ua: "Chromium";v="21", " Not;A Brand";v="99"
 * sec-ch-ua-mobile: ?0
 * sec-ch-ua-platform: "Windows"
 * Upgrade-Insecure-Requests: 1
 * User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36
 * Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,;q=0.8,application/signed-exchange;v=b3;q=0.9
 * Sec-Fetch-Site: cross-site
 * Sec-Fetch-Mode: navigate
 * Sec-Fetch-User: ?1
 * Sec-Fetch-Dest: document
 * Accept-Encoding: gzip, deflate, br
 * ccept-Language: zh-CN,zh;q=0.9
 * Cookie: locale=zh; username=admin%20; rememberMe=true; password=qNWABzv9FC6FC6cQDMXaUbywQhGLompJK53Wa1ph+BTZTfDzv4OQbKFXevNbrszfsOC3T96vd3KtwNC50uabY0UcG3tJMClyMhTapGhyhT+ST07kWc36bCxRFrshTfoR364ydpgW0cDlT5KJkxSkdDEeQrBGpnDiZiFasy2jKIE=
 */
public class HttpRequset {

    /**
     * 请求路径
     */
    private String pathInfo;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求头
     * http 协议的数据 都是一堆 key：value的格式
     */
    private Map<String , String> header;

    public HttpRequset(Reader inReader){

        try{
            //管道
            BufferedReader reader = new BufferedReader(inReader);
            String firstLine = reader.readLine();
            String[] firstLineItems = firstLine.split(" ");
            method = firstLineItems[0];
            pathInfo = firstLineItems[1];
            // 读取接下来的行 ：请求头
            String headerLine;
            header = new HashMap<>();
            while ((headerLine = reader.readLine()) != null){
                if (headerLine.length() == 0){
                    break;
                }
                String[] headerLineItems = headerLine.split(": ");
                header.put(headerLineItems[0] , headerLineItems[1]);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("错误");
        }

    }

    public String getPathInfo() {
        return pathInfo;
    }

    public String getMethod() {
        return method;
    }

    public String  getHeader(String name) {
        return header.get(name);
    }
}
