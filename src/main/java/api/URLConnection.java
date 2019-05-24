package api;

import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnection {
	public static HttpURLConnection getConnection(String url) {
		HttpURLConnection connection = null;
		try {
			// 打开和URL之间的连接
			URL postUrl = new URL(url);
//			SslUtils.ignoreSsl();
			// 打开连接
			connection = (HttpURLConnection) postUrl.openConnection();
			// 设置通用的请求属性
			connection.setDoOutput(true);
			connection.setDoInput(true);
			 // 默认是 GET方式
			connection.setRequestMethod("POST");
			// Post 请求不能使用缓存
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			// 设置请求头参数
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Charset", "UTF-8");
			connection.setRequestProperty("Accept-Charset", "UTF-8");
			connection.setRequestProperty("Connection", "Keep-Alive");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
