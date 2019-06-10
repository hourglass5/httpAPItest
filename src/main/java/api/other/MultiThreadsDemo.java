package api.other;

import java.io.IOException;

import api.HttpURLConnectionUtil;
import api.jsonTools.JsonAnalyzing;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;

public class MultiThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        RunnerThread[] threads = new RunnerThread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new RunnerThread("Runner"+ i);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join(); //等所有子线程都执行完，主线程才停止
        }
    }
    static class RunnerThread extends Thread{
        String name;
        public RunnerThread(String name){
            this.name = name;
        }
        @Override
        public void run() {

            // 并发接口（获取店铺信息）
            String pathCode = "/api/BUserBondBillController/myOpenStore";

            // 给接口传递json格式的参数
            JSONObject paramss = new JSONObject();
            paramss.put("userId", "1087239559747469312"); // 用户id

            HttpURLConnectionUtil getRequestUrl = new HttpURLConnectionUtil();
            String httpResult = getRequestUrl.getHttpRespone(pathCode, paramss);
            System.out.println(httpResult);
        }
    }
}
