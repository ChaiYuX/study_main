package com.study;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main_common {

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        Map<String, Integer> testMap = test.stream().collect(Collectors.toMap(Function.identity(), String::length));

        String testXml = "20240428144354861R2988700000000000000otherAccPay00000318<?xml version=\"1.0\" encoding=\"GBK\" ?><BankData><opRep><serialNo>20240428144354861R29887</serialNo><hostReturnCode>EBYQ1000</hostReturnCode><hostErrorMessage>记录在档中不存在，CMROLROL中行号02141         不存在</hostErrorMessage><RepParam><chargeFee>0.00</chargeFee><postFee>0.00</postFee></RepParam></opRep></BankData>";
        testXml = testXml.substring(56);
        System.out.println(getHostErrorMessage(testXml));

    }


    public static String getHostErrorMessage(String xmlString) {
        try {
            // 创建 DocumentBuilderFactory 和 DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 使用 StringReader 包装 XML 字符串
            // 这里不需要创建实际的 XML 文件，因为我们是直接解析字符串
            // StringReader stringReader = new StringReader(xmlString);

            // 解析 XML 字符串为 Document 对象
            // Document document = builder.parse(stringReader);
            Document document = builder.parse(new InputSource(new StringReader(xmlString)));

            // 获取 hostErrorMessage 标签
            NodeList hostErrorMessages = document.getElementsByTagName("hostErrorMessage");

            // 检查是否找到了 hostErrorMessage 标签
            if (hostErrorMessages.getLength() > 0) {
                // 获取第一个 hostErrorMessage 标签的文本内容
                Element hostErrorMessageElement = (Element) hostErrorMessages.item(0);
                return hostErrorMessageElement.getTextContent();
            } else {
                // 如果没有找到 hostErrorMessage 标签，返回 null 或空字符串
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 在发生异常时返回 null 或空字符串
            return null;
        }
    }




}
