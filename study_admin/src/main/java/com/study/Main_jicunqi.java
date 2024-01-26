package com.study;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main_jicunqi {

    public static long[] getRandomTimestamps() {
        long[] timestamps = new long[2];
        Random random = new Random();
        long minInterval = 4 * 60 * 60; // 4 hours in seconds
        long maxInterval = 9 * 60 * 60; // 9 hours in seconds

        long timestamp1 = System.currentTimeMillis() / 1000; // Current timestamp in seconds

        long minTimestamp2 = timestamp1 + minInterval;
        long maxTimestamp2 = timestamp1 + maxInterval;

        long timestamp2 = minTimestamp2 + random.nextInt((int) (maxTimestamp2 - minTimestamp2 + 1));

        timestamps[0] = timestamp1;
        timestamps[1] = timestamp2;
        return timestamps;
    }

    public static long addMinutesToTimestamp(long timestamp, int minutes) {
        long milliseconds = minutes * 60 * 1000; // 将分钟转换为毫秒
        return timestamp + milliseconds;
    }

    public static void main(String[] args) {
        System.out.println(new Date(1704801027L*1000));
        long[] timestamps = getRandomTimestamps();
        System.out.println("Timestamp 1: " + timestamps[0]);
        System.out.println("Timestamp 2: " + timestamps[1]);
        System.out.println("Timestamp 23: " + addMinutesToTimestamp(timestamps[1] , 20) );

        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random() * 101));
        }

        Long num = 0L;
        System.out.println(0==num);

        Long test = 365L;
        System.out.println(test/10);
        String message = "0000000000F30103F0271B00000000000000000000000000000000000000000000000000000000000000000000000101CF02500000000101E10292000000000000000000000000000000000000000000000000000000000000000000000001017301B2000000000000000000000000000000000000000000000000000000000000000000000001000100000000000100010000000100000001000000940000008B0000015500000177000000AE0001009200030173000001710000007800000092000001740000017500000181000001790000007E00000093000000000000000200000001000D000E00270027000700070037002F00000000"
                .replaceAll(" ", "");
        double result = (double) test / 10;
        System.out.println(result);
        System.out.println(message);
        System.out.println(message.substring(0,18));
        System.out.println(message.substring(18,18+4));
        System.out.println(dealMqttMessage(message));
    }


    public static List<Integer> dealMqttMessage(String hexMessage) {
        String message =hexMessage.replaceAll(" ", "");
        message = message.substring(18+4);
        List<Integer> contentList = new ArrayList<>();
        for (int i = 0; i < message.length(); i += 4) {
            //每4位一个寄存器
            String hexString = message.substring(i, Math.min(message.length(), i + 4));
            // 把寄存器中的16进制数据 转换为10进制
            int decimalValue = Integer.parseInt(hexString, 16);
            contentList.add(decimalValue);
        }
        return contentList;
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static String encrypt(String idCard, int front, int end) {
        if (StrUtil.isEmpty(idCard)) return idCard;
        if ((front + end) > idCard.length()) return idCard;
        if (front < 0 || end < 0) return idCard;
        //计算 ‘*’ 号数量
        int asteriskCount = idCard.length() - (front + end);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < asteriskCount; i++) {
            stringBuilder.append("*");
        }
        String regex = "(\\w{" + String.valueOf(front) + "})(\\w+)(\\w{" + String.valueOf(end) + "})";

        return idCard.replaceAll(regex, "$1" + stringBuilder + "$3");
    }

}
