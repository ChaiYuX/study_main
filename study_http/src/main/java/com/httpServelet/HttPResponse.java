package com.httpServelet;

public class HttPResponse {

    public HttPResponse(String data){
        this.data = data;
    }

    private String data;

    /**
     * 返回的还得是字节
     * @return
     */
    public byte[] getBytes(){
        // 最终返回的数据： 响应行+响应头+空行+响应正文
        return ("HTTP/1.1 200\r\n" +
                "Content-Type: application/json\r\n" +
                "\r\n" +
                data).getBytes();
    }

}
