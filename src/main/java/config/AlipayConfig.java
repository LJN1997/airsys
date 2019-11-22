package config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101600701999";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCeJimo65RRGmqLEaqWjqgXpgsStEt6/Y6mN/86zJRnnqvQdbALuqf2s3tKf2KOpIR84B97WJmffPjCU+g5TJ0bZjvTF2f1oV7RUlyaGCmxwlXJF/YUlODAOvBEwEyOe2y7uo0zFwF0bBIpKpmZUgoHlL5yC5M6L1BI74diVOpO6yHhVK6KswNJc6w7wHuIpnV2UFbe/oipE93+v1ztLLkFpUcAdUEty7jrRIUA4ATsjpBxCcwyG0E4iWSB/JlCxUHobcE7ooGzndet7D4v0PcUYFpcWSHBgBkg7+k8RON0bmtxQjOp+8Lw2LHnPV83TMS8joID2Zg+zc31x/QByWbBAgMBAAECggEAJ0iFep8h1U+BfY/i1skSueUVxQyh3ygSgflQ3bMpfd+s//frxc4UoLQOgP/JZHM7MaWeTE5CwpoRVHvxKCJ+t+qaG6IpwZrW6ZnSxLgRy0TheDUKfCxK85TwT7OQkKfZ53u8TR9+zgN2M2GQi8QUF7P75mo3pPFRuPw+nc9H8FgVoi7vaHD4zoH0oY337BxBno2PrcJhhch0xTXIxV/td4/WCjZ1FJqJjIOsAKVPhy1/NzwM3C1v3xzIG1qRdwhNtDN1MWoPX9EV+qfXvgY0t7PDUH+tW1mB0UyRhTCqfMiVUPcqzFmGi6Rw5ERLWlyzZJp1kuYnZXv9Fr150xLnjQKBgQDR8v4rg32T/EfxMy8oDEHEc6sTwvSAdJedbbWdrEDum4prd+NDtd4965dWJQZNiwIj2XynfQsbasJDuasDUmxjyMcMS9m1YX8xYQr5Fv5We4FeMth1UXGJEndGcdCgbo8JBbYgd5f3NTPHvdlWxmbv6dawRdCDoXqzdkJ5QZpIWwKBgQDA1oEil3yfGawxPHQNjVfI6qEjasLydCTG1qnB2Im+MBZ16adHOK9ASygiglGTVHLVB/iEfUt27KsyFCdNSsIf3X2Dx6Xv+RrEv96jL7hmmhcQGSnmp3YBGLPgtQBSGM4pxGfs1WHpDxXdVYOt4bKt4ZzYyCbEIrxxBpDHByCYEwKBgHw9/znC64qqrexH7O0XK8hU5vWf1k86MArixKpVKGvLsgNdBCmqs6UTCRDagjtbOt36M3FuZydHa0Tm2BP0L95xD5HwRRq4YqvXEMZNXB/ToMAc+Mmcc8K5IcqXSe3W32Bod9oIy+5oFodqivZ2HK53RCw2dGmhItqW7kmRj/qnAoGAYJROErwaHzjlY7dqTEtI9wiD8dALmRCQRsHGPZ6sxgMhjKacL/B03VeG31mzb31xEb6vOfPissovp6IuWOijNwBgV3rLYde6D2YlJEfHLCPqfxaLRMkEMeJkXJtqcLOZtZN3lUb9hZMXmUW18IVETw/a1TvRJpRbGqR2KCgqq98CgYBnwWmSyyoozmnt736GnvFSrvHpKZcOAiTzO84g46H3k5JJyvC7Oue0xg0WlfX5vij8SJDOzFPeqGlp0GyMcuF9WNDfHSjEIsOP8dojoC5YGiea7ajME8CDfLHAG9ggtbWfKOD9JmGtpyA6CAun46iyi9LUtoA9jWqFPdEkuk8Vxw==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAniYpqOuUURpqixGqlo6oF6YLErRLev2Opjf/OsyUZ56r0HWwC7qn9rN7Sn9ijqSEfOAfe1iZn3z4wlPoOUydG2Y70xdn9aFe0VJcmhgpscJVyRf2FJTgwDrwRMBMjntsu7qNMxcBdGwSKSqZmVIKB5S+cguTOi9QSO+HYlTqTush4VSuirMDSXOsO8B7iKZ1dlBW3v6IqRPd/r9c7Sy5BaVHAHVBLcu460SFAOAE7I6QcQnMMhtBOIlkgfyZQsVB6G3BO6KBs53Xrew+L9D3FGBaXFkhwYAZIO/pPETjdG5rcUIzqfvC8Nix5z1fN0zEvI6CA9mYPs3N9cf0AclmwQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "E:\\";


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

