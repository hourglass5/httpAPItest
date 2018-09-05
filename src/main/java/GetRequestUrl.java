import java.io.*;
import java.net.HttpURLConnection;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class GetRequestUrl {
	private String url = "";

	public String geturl() {
		return url;
	}

	public String getHttpRespone(String pathCode, Map<String,String> params) throws IOException {
		String line = "";
		String httpResults = "";
		url = ("http://120.27.13.190:8080/xhjd-report" + pathCode);
		System.out.println(url);
		try {
			HttpURLConnection connection = URLConnection.getConnection(url);

			// 接口参数
			connection.connect();
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(),"UTF-8");

			// 给接口传递json格式的参数
			JSONObject array = new JSONObject(params);
			out.write(array.toString());
			System.out.println(array);
			out.flush();
			
			// 读取响应
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			while ((line = reader.readLine()) != null) {
				httpResults = httpResults + line.toString();
			}
			System.out.println(httpResults);
			reader.close();
			// 断开连接
			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return httpResults;
		
	}
}
