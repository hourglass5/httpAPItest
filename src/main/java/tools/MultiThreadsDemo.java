package tools;

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
            String url = "http://api.fixer.io/latest?base=CNY";
            //使用的是之前接口自动化的http请求框架，不清楚可以参考之前的文章
//            HttpResponse response = new HttpRequest(url)
//                    .setHeaders(null)
//                    .setParams(null)
//                    .doGet();
//            try {
//                String result = EntityUtils.toString(response.getEntity());
//                System.out.println("Thread " + name + " response: " + result);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
}
