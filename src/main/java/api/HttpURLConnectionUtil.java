package api;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionUtil {
	private String url = "";

	public String geturl() {
		return url;
	}

	public String getHttpRespone(String pathCode, JSONObject paramss) {
		String line = "";
		String httpResults = "";
		url = ("http://120.79.35.28:8380" + pathCode);
		System.out.println(url);
		try {
			HttpURLConnection connection = null;
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
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Charset", "UTF-8");
			connection.setRequestProperty("Accept-Charset", "UTF-8");
			connection.setRequestProperty("Connection", "Keep-Alive");

			// 如果包含一个请求体。通过将数据写入一个由getOutStream()返回的输出流来传输数据。
			connection.connect();
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(),"UTF-8");

			// 给接口传递json格式的参数
			out.write("parameters=" + paramss.toString());
			out.flush();
			
			// 读取响应。响应头通常包含元数据例如响应体的内容类型和长度，修改日期和会话cookies。响应体可以被由getInputStream返回的输入流读取。如果响应没有响应体，则该方法会返回一个空的流
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			while ((line = reader.readLine()) != null) {
				httpResults = httpResults + line;
			}
			reader.close();
			// 断开连接会释放被一个connection占有的资源，这样它们就能被关闭或再次使用。
			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return httpResults;
		
	}
}
