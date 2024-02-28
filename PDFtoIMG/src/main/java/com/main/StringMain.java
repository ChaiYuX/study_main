package com.main;

import cn.hutool.core.util.StrUtil;
import com.entity.Marker;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMain {

    public static void main(String[] args) {
        String input = "hello_world";
        Pattern pattern = Pattern.compile("_(\\w)");
        Matcher matcher = pattern.matcher(input);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(result, matcher.group(1).toUpperCase());
        }

        matcher.appendTail(result);
        System.out.println(result.toString());
    }

    /*public static void main(String[] args) {



        String input = "P90\\n\\u5929\\u9a84\\u56fd\\u9645\\u4f1a\\u5c55\\nTANJAO INTERNATIONAL EXHIBITION\\nWhat do you want?\\nPlease leave your information and purchase intention, we will match you\\nwith the most suitable products and services.\\nOUR SERVICES\\nINDUSTRIAL AUTOMATION SOLUTIONS\\nENERGY MONITORING SYSTEM\\nCHECKWEIGHER SOLUTIONS\\nCAMERA BASED INSPECTION SYSTEM\\nSERIALIZATION & AGGREGATION\\n(TRACK & TRACE SOLUTIONS)\\nSIEMENS INOVANCE Propix Schneider\\nElectric\\nIngenuity for life\\nNature of buyer: Wholesaler\\nProducts you want to buy:\\nAnnual purchase quantity:\\nIn which country did you buy products before?\\nBangladest.\\nWhatsApp\\/Facebook\\/Other social accounts:\\nEmail:\\n01603508134\\nWWW.HOY\\nROTIZIV\\nRetailer Agent\\nHOMUOYU\\nPlastic Products, botols";

        List<String> markerTexts = new ArrayList<>();
        markerTexts.add(usefulKey1);
        markerTexts.add(usefulKey2);
        markerTexts.add(usefulKey3);
        markerTexts.add(usefulKey4);
        markerTexts.add(usefulKey5);
        markerTexts.add(usefulKey6);
        markerTexts.add(usefulKey7);
        List<Marker> markers = findMarkers(input, markerTexts);
        markers.sort(Comparator.comparingInt(m -> m.index));
        List<String> markerOrder = new ArrayList<>();
        for (Marker marker : markers) {
            markerOrder.add(marker.text);
        }
        System.out.println(markerOrder);

        for (int i = 0; i < markerOrder.size(); i++) {
            if (i + 1 < markerOrder.size()) {
                String result = extractStringBetweenMarkers(input, markerOrder.get(i), markerOrder.get(i + 1));
                System.out.println(markerOrder.get(i) + " " + result);
            } else {
                String result = extractStringBetweenMarkers(input, markerOrder.get(i) ,null);
                System.out.println(markerOrder.get(i) + " " + result);
            }
        }
    }*/

    public static String usefulKey1 = "Nature of buyer";
    public static String usefulKey2 = "Products you want to buy";
    public static String usefulKey3 = "Annual purchase quantity";
    public static String usefulKey4 = "In which country did you buy products before";
    public static String usefulKey5 = "WhatsApp/Facebook/Other social accounts";
    public static String usefulKey6 = "Nature of buyer";
    public static String usefulKey7 = "Email";

    private static List<Marker> findMarkers(String input, List<String> markerTexts) {

        List<Marker> markers = new ArrayList<>();
        Pattern pattern = Pattern.compile("(" + String.join("|", markerTexts) + ")");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String match = matcher.group();
            int index = matcher.start();
            markers.add(new Marker(match, index));
        }

        return markers;
    }


    public static String extractStringBetweenMarkers(String input, String startMarker, String endMarker) {

        int startIndex = input.indexOf(startMarker) + startMarker.length();
        if (startIndex == -1) {
            return null; // Start marker not found
        }
        int endIndex = -1;
        if (StrUtil.isNotEmpty(endMarker)) {
            endIndex = input.indexOf(endMarker, startIndex);

        } else {
            endIndex = input.length();
        }
        if (endIndex == -1) {
            return null; // End marker not found
        }

        return input.substring(startIndex, endIndex);
    }


}
