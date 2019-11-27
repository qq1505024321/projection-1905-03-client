package com.jk.controller;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101600700927";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC2GOUYsKaEpxKP54gRPrpXcyL4SWAv14y9INfhtBaII/5gqL91LZymyXmDsSnbSE/wz/IaWSqqjeLrsP5WZcklsWRwaDvZUKbpKYdsYe96qyU+Js1LskFJf+7SQuOm0ijhb1B62uImfY1ku47LUVZ2IpMaHPVeoz2NWM9x+ipNlK8CuTrXmfjaJeCmJBqCVHnmlOCY2eHsf4BS4czWUyGSfqmX94EiqjiIXAxhP9kKHh8jidXRv6tp2EGKWQSYRnE+08fAnBIEwuEpyCQvPf4927lm4Tymi5oalL/izb53uy2MWGfhuveVOO09tBQVvjiHNCwnGIlWc4aWKteLcKKNAgMBAAECggEBAJBFKwUjt9ozUCaJJqmbDCGKy/Lwl29wFEYnhkKA3rUf50MHjyC0cX9G8qoeq+3a3dMJvWOYr5AO9/EJ+ofS/smJQO059+jV2Fe0mmGJOiXzAH+8WDyXztf/ruQRMLIToWXyPk4HqtMZ9/MOEjUNjTXtcKRouxIuvO6GpVxE+k0Zn2H6qOYuxszcEPT+eQjDyLevPCOMbYK6kfZVnbV5lY/3NbjA8gDILQowfWU1TP9Ekd4BS5LWK4yeqW0wAhKvFPPeSYR/unyv52eI8J5tqyM2rg7PTRlnuzyS9oWL+LM/m/d4/TY2zRCh+7v+OKJGKokTiOP79VB2wZjVTaTc3eECgYEA6WMKc5jmuYfYdO7PS/52ECQOZGWIYw4lLeQyhxw5De6a6QrAjXen7HJQFOYWqfBpNQQNn8bueLbz75qgtjy8CAmA0ta5GzMI/ECv+CjBu4qAvD/eI4wkHmcvL2qQUf8yJoV7In24bfMuuuLU6QtyHKJe/dYc5JjkyHTQ/6cuHcUCgYEAx72owkfjF4FsNj2v109KylGqDwc2nCT12i+T8W1KQZVrjRQi1ktN9aytUf/YARokiF7YPRoWe5SnH72wc2GdN5vjtzI6knRVP/t33q5BPv5Y7ThNGTpUSn/AAvrpiDkM2ZLBEOBPQgMdIemK1Ld7lF8TgEV9s1KLG9RGXG3iRikCgYEAyoamoC+UMHXg8X/2pYSYoWMYlijBlOvGea9n5XUpUZy4EvjApUKrlvSP58LO8gNs2JO+2uL/OAPTZR4yzlGf/f15K/0nPqIn7vaXfWqoy3ziP/nQY9qN0VBLUwNPX8hrlaAJfaHJdKgt6gFDL0Q+bvi8I9w00G6ZQhaU8vT5gN0CgYAly5SQVqv4+atxRBDu6/kZ+YP1XgcOWswOoiwbZfPEHzL/ugyxggRZdXhCaOgFpV2+VDwUq8gPUFyjW/B0lMb8C8p2EtIUfmDXP406HL0J33USRjIIkQn8ItpBdhsUhL8SuHtB5z/4HMC5dwinIaUHuUnmXr/fW8Io3O0Hdl93qQKBgQDlou1suCQyvtbZZXyhI7BheaEejcA2o5HitNgYl9qfadaIlHT/f4wfhxlecgNiB3JbbXX1qbQ4nnP5IjVwT6P9Kw06IDZtx/9gy3CFTMU8udaF18SE3YWLB7a19ArJf0enIrc/wIKGitDOgh1jwIG4yeFYtJI7NlR6VCbrj45JiQ==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAthjlGLCmhKcSj+eIET66V3Mi+ElgL9eMvSDX4bQWiCP+YKi/dS2cpsl5g7Ep20hP8M/yGlkqqo3i67D+VmXJJbFkcGg72VCm6SmHbGHveqslPibNS7JBSX/u0kLjptIo4W9QetriJn2NZLuOy1FWdiKTGhz1XqM9jVjPcfoqTZSvArk615n42iXgpiQaglR55pTgmNnh7H+AUuHM1lMhkn6pl/eBIqo4iFwMYT/ZCh4fI4nV0b+radhBilkEmEZxPtPHwJwSBMLhKcgkLz3+Pdu5ZuE8pouaGpS/4s2+d7stjFhn4br3lTjtPbQUFb44hzQsJxiJVnOGlirXi3CijQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/sha/tozhifuyemian";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/sha/tozhifuyemian";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
