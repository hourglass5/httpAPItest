package api;

import api.Common;
import api.URLConnectionUtil;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class testCase1 {


    public String httpResult = null, resultCode = null;
    public static String pathCode = null;
    URLConnectionUtil getRequestUrl = new URLConnectionUtil();

    @BeforeClass
    public void beforeclass() {
        System.out.println("this is before class");
    }

    @Test
    public void test() throws IOException {
        System.out.println("this is test case");
        // 用户存量关系
        pathCode = "/userStock/relation";

        // 给接口传递json格式的参数
        JSONObject paramss = new JSONObject();
        paramss.put("endReturnTime", ""); // 截止日期
        paramss.put("uid", ""); // 用户ID
        paramss.put("username", ""); // 用户手机号
        paramss.put("realName", ""); // 姓名
        paramss.put("flag", "1"); // 排序方式
        paramss.put("currentpage", "1"); // 当前页
        paramss.put("pagesize", "20"); // 每页展示件数

        httpResult = getRequestUrl.getHttpRespone(pathCode, paramss);
        System.out.println(httpResult);
        resultCode = Common.getJsonValue(httpResult, "message");
        Assert.assertEquals(resultCode,"获取用户存量关系列表成功");

    }

    @AfterClass
    public void afterclass() {
        System.out.println("this is after class");
    }

}
