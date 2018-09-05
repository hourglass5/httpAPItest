import org.json.JSONException;
import org.json.JSONObject;

public class Common {
	/**
	 * 
	 * 
	 * @author rui
	 * @version 1.0 2017/10/16
	 * @return JsonValue
	 **/
	public static String getJsonValue(String JsonString, String JsonId) {
		String JsonValue = "";
		if (JsonString == null || JsonString.trim().length() < 1) {
			return null;
		}
		try {
			JSONObject obj1 = new JSONObject(JsonString);
			JsonValue = (String) obj1.getString(JsonId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return JsonValue;
	}
}
