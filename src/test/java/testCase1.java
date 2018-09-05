import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class testCase1 {


    public String httpResult = null, resultCode = null;
    public static String pathCode = null;
    GetRequestUrl getRequestUrl = new GetRequestUrl();

    @BeforeClass
    public void beforeclass() {
        System.out.println("this is before class");
    }

    @Test
    public void test() throws IOException {
        System.out.println("this is test case");
        // 用户存量关系
        pathCode = "/userStock/relation";

        Map<String,String> params =  new HashMap<String,String>();
        params.put("endReturnTime", ""); // 截止日期
        params.put("uid", ""); // 用户ID
        params.put("username", ""); // 用户手机号
        params.put("realName", ""); // 姓名
        params.put("flag", "1"); // 排序方式
        params.put("currentpage", "1"); // 当前页
        params.put("pagesize", "20"); // 每页展示件数

//        httpResult = hc.doPost("https://120.55.42.27/caifu"+ pathCode, params, "utf-8");
        httpResult = getRequestUrl.getHttpRespone(pathCode, params);
        System.out.println(httpResult);
        resultCode = Common.getJsonValue(httpResult, "message");
        Assert.assertEquals(resultCode,"获取用户存量关系列表成功");

    }

    @AfterClass
    public void afterclass() {
        System.out.println("this is after class");
    }

}
