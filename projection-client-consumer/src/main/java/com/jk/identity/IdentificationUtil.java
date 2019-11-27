package com.jk.identity;

import ch.qos.logback.core.util.FileUtil;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.util.Base64Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ccl
 * @create 2019/11/18
 * @since 1.0.0
 */
public class IdentificationUtil { // 身份证识别URL
 /*   private static String idcardIdentificate = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
    // 获取 access_token URL
    private static String GETTOKEN_URL = "https://aip.baidubce.com/oauth/2.0/token";
    // 用户的API_KEY
    private static String API_Key = "D2b29qPZy15NoZEaAp7PSLCH";
    // 用户的Secret_Key
    private static String Secret_Key = "coI7YFMjY5hYnyOYduwRAgho0ookY7PC";

    *//**
     * 获取API访问token 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     *
     * @param ak - 百度云官网获取的 API Key
     * @param sk - 百度云官网获取的 Securet Key
     * @return assess_token 示例：
     * "24.cf4ba2b027cc124bbd210a69ffd137b8.2592000.1527040641.282335-11136581"
     *//*
    public static String getAuth(String ak, String sk) {
        // 获取token地址
        String getAccessTokenUrl = GETTOKEN_URL
                // 1. grant_type为固定参数
                + "?grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + API_Key
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + Secret_Key;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            *//**
             * 返回结果示例
             *//*
            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }

    *//**
     * 识别获取身份证正面相关信息
     *
     * @param front
     * @return
     *//*
    public static Map<String, Object> identification(String front) {// 执行认证查询
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            // 识别身份证正面id_card_side=front;识别身份证背面id_card_side=back;
            // 正面
            byte[] imgData = FileUtil.readFileByBytes(front);
            String imgStr = Base64Util.encode(imgData);
            // 识别身份证正面id_card_side=front;识别身份证背面id_card_side=back;
            String params = "id_card_side=front&" + URLEncoder.encode("image", "UTF-8") + "="
                    + URLEncoder.encode(imgStr, "UTF-8");
            *//**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             *//*
            String accessToken = getAuth(API_Key, Secret_Key);
            String result = HttpUtil.post(idcardIdentificate, accessToken, params);
            JSONObject jsonObject = new JSONObject(result);// 转换成JSON格式 身份证正面所有信息
            map.put("result", jsonObject);// 身份证所有信息
            map.put("address", (JSONObject) jsonObject.getJSONObject("words_result").get("住址"));// 地址
            map.put("birth", (JSONObject) jsonObject.getJSONObject("words_result").get("出生"));// 出生
            map.put("name", (JSONObject) jsonObject.getJSONObject("words_result").get("姓名"));// 姓名
            map.put("IDCard", (JSONObject) jsonObject.getJSONObject("words_result").get("公民身份号码"));// 身份证ID
            map.put("sex", (JSONObject) jsonObject.getJSONObject("words_result").get("性别"));// 性别
            map.put("nation", (JSONObject) jsonObject.getJSONObject("words_result").get("民族"));// 民族
            Set<Map.Entry<String, Object>> entrySet = map.entrySet();
            for (Map.Entry<String, Object> entry : entrySet) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    *//**
     * 获取身份证背面相关信息
     *
     * @param back
     * @return
     *//*
    public static Map<String, Object> idCardVerify(String back) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            // 识别身份证正面id_card_side=front;识别身份证背面id_card_side=back;
            byte[] imgData = FileUtil.readFileByBytes(back);
            String imgStr = Base64Util.encode(imgData);
            // 识别身份证正面id_card_side=front;识别身份证背面id_card_side=back;
            String params = "id_card_side=back&" + URLEncoder.encode("image", "UTF-8") + "="
                    + URLEncoder.encode(imgStr, "UTF-8");
            *//**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             *//*
            String accessToken = getAuth(API_Key, Secret_Key);
            String result = HttpUtil.post(idcardIdentificate, accessToken, params);
            JSONObject jsonObject = new JSONObject(result); // 转换成JSON格式 身份证反面所有信息
            map.put("result", jsonObject);// 所有信息
            map.put("issueDate", (JSONObject) jsonObject.getJSONObject("words_result").get("签发日期"));// 签发日期
            map.put("expiryDate", (JSONObject) jsonObject.getJSONObject("words_result").get("失效日期")); // 失效日期
            map.put("issueyAuthority", (JSONObject) jsonObject.getJSONObject("words_result").get("签发机关"));// 签发机关
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/
}