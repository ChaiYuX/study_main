package com.study;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.entity.BankBill;

import java.io.IOException;
import java.util.Random;

public class Main_test {


    public static void main(String[] args) throws IOException {

        System.out.println(DateUtil.now());

        String payxml = "20231206155627861D5755500000000000000otherAccPay00000274\n" +
                "<?xml version=\"1.0\" encoding=\"GBK\" ?>\n" +
                "<BankData>\n" +
                "    <opRep>\n" +
                "        <serialNo>20231206155627861D57555</serialNo>\n" +
                "        <hostReturnCode>00000000</hostReturnCode>\n" +
                "        <hostErrorMessage>交易成功</hostErrorMessage>\n" +
                "        <RepParam>\n" +
                "            <chargeFee>3.00</chargeFee>\n" +
                "            <postFee>0.00</postFee>\n" +
                "        </RepParam>\n" +
                "    </opRep>\n" +
                "</BankData>";
        JSONObject payObject = JSONUtil.xmlToJson(payxml);
        System.out.println(JSONUtil.toJsonStr(payObject));

        int number = generateUniqueNumber();
        System.out.println(number);

        String test = "20231206162247861D5387600000000queryAccHisDetail00003766\n" +
                "<?xml version=\"1.0\" encoding=\"GBK\" ?>\n" +
                "<BankData>\n" +
                "    <opRep>\n" +
                "        <serialNo>20231206162247861D53876</serialNo>\n" +
                "        <hostReturnCode>00000000</hostReturnCode>\n" +
                "        <hostErrorMessage>交易成功</hostErrorMessage>\n" +
                "        <turnPageTotalNum>1</turnPageTotalNum>\n" +
                "        <RepParam>\n" +
                "            <tranDetail>\n" +
                "                <row>\n" +
                "                    <currencyType>01</currencyType>\n" +
                "                    <payAmount>0000000000001.00</payAmount>\n" +
                "                    <recAmount>0000000000000.00</recAmount>\n" +
                "                    <transferDate>20231206</transferDate>\n" +
                "                    <transferTime>121225</transferTime>\n" +
                "                    <balance>0000009420326.28</balance>\n" +
                "                    <vouchersNo/>\n" +
                "                    <rem>[君之安医疗服务平台]行内转账,流水交易号:-1</rem>\n" +
                "                    <summary>0100</summary>\n" +
                "                    <account>861502101421003013</account>\n" +
                "                    <accountName>内骐纯馈斗科技有限公司</accountName>\n" +
                "                    <transferFlowNo>861777777MGn0000001</transferFlowNo>\n" +
                "                    <accountBankNo/>\n" +
                "                    <sysDate>20231206</sysDate>\n" +
                "                </row>\n" +
                "            </tranDetail>\n" +
                "        </RepParam>\n" +
                "    </opRep>\n" +
                "</BankData>\n";
//        BankBill bankBill = XmlUtil.xmlToBean()
        JSONObject jsonObject = JSONUtil.xmlToJson(test);
        JSONObject tranDetailObject = jsonObject
                .getJSONObject("BankData")
                .getJSONObject("opRep")
                .getJSONObject("RepParam")
                .getJSONObject("tranDetail");
//        JSONArray rowJSONArray = tranDetailObject.getJSONArray("row");
//        System.out.println(rowJSONArray.size());
//        BankBill bankBill = new BankBill();
        if (tranDetailObject.get("row") instanceof JSONArray) {
            System.out.println("JSONArray");
        }
        if (tranDetailObject.get("row") instanceof JSONObject) {
            System.out.println("JSONObject");
        }
        /*Node node = XmlUtil.read(xmlString);
        BankBill bankBill = jsonObject.toBean(BankBill.class);*/
//        BeanUtil.copyProperties(jsonObject, bankBill);
        System.out.println(JSONUtil.toJsonStr(jsonObject));
        System.out.println("转换成功");
        String start = "20231206162247861D5387600000000queryAccHisDetail00003766";
        System.out.println(start.length());

        try {
            String xml = "20231206162247861D5387600000000queryAccHisDetail00003766\n" +
                    "<?xml version=\"1.0\" encoding=\"GBK\" ?>\n" +
                    "<BankData>\n" +
                    "    <opRep>\n" +
                    "        <serialNo>20231206162247861D53876</serialNo>\n" +
                    "        <hostReturnCode>00000000</hostReturnCode>\n" +
                    "        <hostErrorMessage>交易成功</hostErrorMessage>\n" +
                    "        <turnPageTotalNum>8</turnPageTotalNum>\n" +
                    "        <RepParam>\n" +
                    "            <tranDetail>\n" +
                    "                <row>\n" +
                    "                    <currencyType>01</currencyType>\n" +
                    "                    <payAmount>0000000000001.00</payAmount>\n" +
                    "                    <recAmount>0000000000000.00</recAmount>\n" +
                    "                    <transferDate>20231206</transferDate>\n" +
                    "                    <transferTime>121225</transferTime>\n" +
                    "                    <balance>0000009420326.28</balance>\n" +
                    "                    <vouchersNo/>\n" +
                    "                    <rem>行内转账</rem>\n" +
                    "                    <summary>0100</summary>\n" +
                    "                    <account>861502101421003013</account>\n" +
                    "                    <accountName>内骐纯馈斗科技有限公司</accountName>\n" +
                    "                    <transferFlowNo>861777777MGn0000001</transferFlowNo>\n" +
                    "                    <accountBankNo/>\n" +
                    "                    <sysDate>20231206</sysDate>\n" +
                    "                </row>\n" +
                    "                <row>\n" +
                    "                    <currencyType>01</currencyType>\n" +
                    "                    <payAmount>0000000000001.00</payAmount>\n" +
                    "                    <recAmount>0000000000000.00</recAmount>\n" +
                    "                    <transferDate>20231206</transferDate>\n" +
                    "                    <transferTime>141026</transferTime>\n" +
                    "                    <balance>0000009420325.28</balance>\n" +
                    "                    <vouchersNo/>\n" +
                    "                    <rem>行内转账</rem>\n" +
                    "                    <summary>0100</summary>\n" +
                    "                    <account>861502101421003013</account>\n" +
                    "                    <accountName>内骐纯馈斗科技有限公司</accountName>\n" +
                    "                    <transferFlowNo>861777777MGj0000001</transferFlowNo>\n" +
                    "                    <accountBankNo/>\n" +
                    "                    <sysDate>20231206</sysDate>\n" +
                    "                </row>\n" +
                    "            </tranDetail>\n" +
                    "        </RepParam>\n" +
                    "    </opRep>\n" +
                    "</BankData>\n";
            JSONObject jsonObject1 = JSONUtil.xmlToJson(xml);
            System.out.println(JSONUtil.toJsonStr(jsonObject1));
            JSONObject tranDetailObject2 = jsonObject1
                    .getJSONObject("BankData")
                    .getJSONObject("opRep")
                    .getJSONObject("RepParam")
                    .getJSONObject("tranDetail");
            if (tranDetailObject2.get("row") instanceof JSONArray) {
                System.out.println("JSONArray");
            }
            if (tranDetailObject2.get("row") instanceof JSONObject) {
                System.out.println("JSONObject");
            }
            JSONArray rowJSONArray2 = tranDetailObject2.getJSONArray("row");
            System.out.println(rowJSONArray2.size());
            BankBill bankBill1 = new BankBill();
            bankBill1 = jsonObject1.toBean(BankBill.class);
            System.out.println("转行成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int generateUniqueNumber() {
        boolean[] used = new boolean[9000];
        Random random = new Random();

        int randomNumber;
        do {
            randomNumber = random.nextInt(9000) + 1000;
        } while (used[randomNumber - 1000]);

        used[randomNumber - 1000] = true;

        return randomNumber;
    }

}
