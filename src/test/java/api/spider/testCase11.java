package api.spider;

import api.HttpURLConnectionUtil;
import api.jsonTools.JsonAnalyzing;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase11 {


    public String httpResult = null, checkResult = null;
    public static String pathCode = null;
    HttpURLConnectionUtil getRequestUrl = new HttpURLConnectionUtil();

    @BeforeClass
    public void beforeclass() {
        System.out.println("this is before class");
    }

    @Test
    public void test() throws IOException {
        System.out.println("this is test case");
        // 用户存量关系
        pathCode = "/api/BUserBondBillController/myOpenStore";

        // 给接口传递json格式的参数
        JSONObject paramss = new JSONObject();
        paramss.put("userId", "1087239559747469312"); // 用户id

        httpResult = getRequestUrl.getHttpRespone(pathCode, paramss);
        System.out.println(httpResult);
        String data = JsonAnalyzing.getObjectValue(httpResult, "data");
        System.out.println(data);
        checkResult = JsonAnalyzing.getStringValue(data, "storeName");
        Assert.assertEquals(checkResult,"糯米糯米你不开花");

    }

    @AfterClass
    public void afterclass() {
        System.out.println("this is after class");
    }

}
