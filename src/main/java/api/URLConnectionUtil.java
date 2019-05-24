package api;

import java.io.*;
import java.net.HttpURLConnection;

import org.json.JSONObject;

public class URLConnectionUtil {
	private String url = "";

	public String geturl() {
		return url;
	}

	public String getHttpRespone(String pathCode, JSONObject paramss) {
		String line = "";
		String httpResults = "";
		url = ("http://120.27.13.190:8080/xhjd-report" + pathCode);
		System.out.println(url);
		try {
			HttpURLConnection connection = URLConnection.getConnection(url);

			// 如果包含一个请求体。通过将数据写入一个由getOutStream()返回的输出流来传输数据。
			connection.connect();
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(),"UTF-8");

			// 给接口传递json格式的参数
			out.write(paramss.toString());
			out.flush();
			
			// 读取响应。响应头通常包含元数据例如响应体的内容类型和长度，修改日期和会话cookies。响应体可以被由getInputStream返回的输入流读取。如果响应没有响应体，则该方法会返回一个空的流
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			while ((line = reader.readLine()) != null) {
				httpResults = httpResults + line;
			}
			System.out.println(httpResults);
			reader.close();
			// 断开连接会释放被一个connection占有的资源，这样它们就能被关闭或再次使用。
			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return httpResults;
		
	}
}
