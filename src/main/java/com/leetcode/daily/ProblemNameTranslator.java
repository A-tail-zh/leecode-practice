package com.leetcode.daily;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Random;

public class ProblemNameTranslator {

    private static final String APP_ID = "20250208002268789";
    private static final String SECRET_KEY = "wwLA00vgsji1pRb2qQcT";
    private static final String API_URL = "https://fanyi-api.baidu.com/api/trans/vip/translate";

    public static String translate(String chineseName) {
        try {
            String salt = String.valueOf(new Random().nextInt(10000));
            String sign = generateSign(APP_ID, chineseName, salt, SECRET_KEY);

            String requestUrl = API_URL +
                    "?q=" + URLEncoder.encode(chineseName, "UTF-8") +
                    "&from=zh&to=en" +
                    "&appid=" + APP_ID +
                    "&salt=" + salt +
                    "&sign=" + sign;

            String result = sendGetRequest(requestUrl);
            String translated = parseDstField(result);

            return translated != null ? DailyUtils.toCamelCase(translated) : fallback(chineseName);

        } catch (Exception e) {
            return fallback(chineseName);
        }
    }

    private static String parseDstField(String json) {
        // 简易解析：查找 "dst":"..." 之间的内容
        String key = "\"dst\":\"";
        int start = json.indexOf(key);
        if (start == -1) return null;
        start += key.length();
        int end = json.indexOf("\"", start);
        if (end == -1) return null;

        String dst = json.substring(start, end);
        // 处理简单的 Unicode 转义 (可选)
        return dst.replace("\\u0020", " ");
    }

    private static String generateSign(String appId, String q, String salt, String secretKey) throws Exception {
        String signStr = appId + q + salt + secretKey;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(signStr.getBytes(StandardCharsets.UTF_8));
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) hex.append(String.format("%02x", b));
        return hex.toString();
    }

    private static String sendGetRequest(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder res = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) res.append(line);
            return res.toString();
        }
    }

    public static boolean isChinese(String text) {
        return text != null && text.matches(".*[\\u4e00-\\u9fa5]+.*");
    }

    private static String fallback(String text) {
        return DailyUtils.toCamelCase(text);
    }
}