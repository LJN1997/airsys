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

public class AlipayConfig1 {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101700707110";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCHKaEBjz1WRaKVKvtA20nKyhCDPnveJd337zu9v2h+Posvpe6ZSp/RRzJ3z0LR6xWhLrFRglvoN+m9B5K1JMrZ+YXM6YJI1OxD/3QntQowKBVvVT1q7HUjecUxBvS3qShMjFf/K4O7+FAe5teXpO8wrtYN0fKZPdWCsfWAV1zPUu7oKX/xiWHupk7/Z6qI1K8utcEuGIEFAtMREUquMJl+N4027xme9WcIkELCegbV3KXt5Jubu1cOFGHI9yN3b/hHM1eoHxiSfdREgqTZUZsG011GLPHDxEl5HH6rQklkkOURmh9iJthBzMQHy10H2oM5+ogD1vOoVrqCA8E3x5V1AgMBAAECggEBAIT3VwUJvPWaG49TcUkkcTul/Qif94tbBTpbhxHrswg+zv5Y5pi26PIgcG2c38dS1Txzisz8yR1xo+fqA1FgmI5HAnHLZffwP13FeKd3WkZ1qGCWIo2FgNcde/f3N9dV+ecUSZ0lWbsZVPiRb5YnE4d49+swltBaHCkumK1hRFRPd5w6xlFs0j4kkQLhcC2Sr0vmGlZpcbvm5DwkpfNv9yv2lanygSpZ5gHpL11oBoCxB/lkMOp340LVKXb5p+UZWS4bjryOanOHzkvoaukQNmmhgs30oc3M50ZKntPkrBcAynFqE7fM/zOmU9EmrrAlANLxBIzccBszc92/c/vEBSECgYEA2NEZCvCFUy6tgXxxUMoJBM4DJgiaIIBWTfcTt4qNIGzCxyHv9kJTSry98hKgMACnUYJlUDBhvNyrh8GJuFcqwv3EDBWMY9THNmR7rWQ7tUMSxdxh2iYl0fQzOYzLNSJf6D1o5UFvK4Dzw99UPeYh3USkdmfHBHbIiXxNJ8viB1sCgYEAn5bZLLBBQW+sQDAjqwmn8QfDk3D0OjAECLHkBtyF++VHZ+T/eaZpsXPx4p/PySOTgzOCbiUEequsl0XVrZW8LXmCXf8IVqSsSRwBihUDebjbYlW4OW/BIoh+Q0Avu76hTjQzv3kOHQLFd4EEq5q76pKRuhJamInBNgE4nAuVP28CgYATRwwl99qy2aydnbXpi/0fSz3mbM9fYmnKBtTe9de0cVckI3VVfPIw6/Urh9JsUjKOQbzGU3btNuWdbWzUUhPAQJXkySmxWqLXyDli4k2YwTzzELQ2lDu6ni7LyCPtNoA2gvdHovjCcnW6DapM0qBiLw88Y9/DGtibuMyXZD5VjwKBgH/76+MI3uxpcIxxjslGDycfgNsnhNV9WF7YuvQ9uj3PHDrXzYJz0ON9BokmfO7j1xMrJfjLOxJdxyXx3XE+WhFmFwTm2HsTyQ9ApINmYsklVNtBv2Jgm1Tkfc3VFfLM6HPdLXrqzES7yj0SfPpaN0XhkXjV603Ve9uhkxKhv2mFAoGAJ4hn/jrW+I3EjFQOFPS/deULIjDNrS4OMSLpUh+xzytt1Q4uCRQFvbcTR6oXiE+SKNJ49eqr0dsjZXGLabl4PLf/cK8BfJo+q6H1msPRZtwV3v1HXa3nVGUFmyVCeUJgVqZPSLnGGipV19OV06TOCEit1q3VctVyMpKj60IRxmk=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxRQlW89NIhGpb2ZusFJp6F3mQqbNgdGDL3QMWrGgrftEzNwHLZ4HGoR3Mhzyd1epCKYqEooObzeVLVYoj+LDps0sxlIWetpvIgqJriJWzda9w2zWUWiVOaGreqmfWXGDW3NnDBcYZCcRoQhliRrsrEwtM2DTljVtJzB+wuwiq1rYjtDDZ0wpsWOkxsRrYh7JMu/IUdo+yTEOsEYYPSQntL76Ih7u/HduZi1slUzecWlCb4vIzKS5PbrFxzS26uMDNz7VOhVEVRzpBDu5Bbhbp7eY2WpDrFt3oeECk5Md77bDOoQSeIt2UKRer52gb/i86Bo4fHA09DE6mWkan6dYFwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://airsyssunny.free.idcfengye.com/airsys/sales/query";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


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


