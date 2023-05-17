package cn.cwc.ai.api.test;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {

    /**
     * CloseableHttpClient是在HttpClient的扩展的，是目前推荐的用法。不仅可以简单设置请求头，还可以利用fastjson转换请求或返回结果字符串为json格式。
     * HttpClient是一个简单的HTTP客户端（不是浏览器），可以看做一个增强版的HttpURLConnection，
     * 它关注于如何发送请求、接收响应，以及管理HTTP连接，但不会缓存服务器的响应，不能执行HTML页面中嵌入的Javascript代码；也不会对页面内容进行任何解析、处理。
     *
     * 作者：小斑虎
     * 链接：https://www.jianshu.com/p/9e69387f60f4
     * 来源：简书
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @throws IOException
     */

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/88885254184412/topics?scope=all&count=20");

        get.addHeader("cookie", "zsxq_access_token=AD0B6217-8853-941A-1C79-162033BA46CB_B487BA3EA5723C1F; abtest_env=product; " +
                "zsxqsessionid=7a065a8e97ecb5038546d68756496a71; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22548821211524184%22%2C%22" +
                "first_id%22%3A%22186c065aba24a0-01f7926fabb85cc-26031951-1327104-186c065aba38d4%22%2C%22props%22%3A%7B%22%24latest_" +
                "traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%" +
                "8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fbugstack.cn%2F%22%7D%2C%22identities%22%3A%22eyI" +
                "kaWRlbnRpdHlfY29va2llX2lkIjoiMTg2YzA2NWFiYTI0YTAtMDFmNzkyNmZhYmI4NWNjLTI2MDMxOTUxLTEzMjcxMDQtMTg2YzA2NWFiYTM4ZDQiLCIkaWRl" +
                "bnRpdHlfbG9naW5faWQiOiI1NDg4MjEyMTE1MjQxODQifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_i" +
                "d%22%2C%22value%22%3A%22548821211524184%22%7D%2C%22%24device_id%22%3A%22186c065aba24a0-01f7926fabb85cc-26031951-1327104-186" +
                "c065aba38d4%22%7D; UM_distinctid=18828b59d7bfa9-043bbfd39ab877-26031a51-1fa400-18828b59d7cf8e");
        get.addHeader("Content-Type", "application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }



}
