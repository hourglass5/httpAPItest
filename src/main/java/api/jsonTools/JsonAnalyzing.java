package api.jsonTools;

import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonAnalyzing {
    // 类型 [String]
    public static String getStringValue(String JsonString, String JsonId) {
        String JsonValue = "";
        if (JsonString == null || JsonString.trim().length() < 1) {
            return null;
        }
        try {
            JSONObject obj1 = new JSONObject(JsonString);
            JsonValue = obj1.getString(JsonId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return JsonValue;
    }

    // 类型 [object]
    public static String getObjectValue(String JsonString, String JsonId){
        String JsonValue = "";
        if (JsonString == null || JsonString.trim().length()<1){
            return null;
        }
        try{
            JSONObject obj1 = new JSONObject(JsonString);
            JsonValue = obj1.getJSONObject(JsonId).toString();
        } catch (JSONException e){
            e.printStackTrace();
        }
        return JsonValue;
    }

    // 类型 [int]
    public static int getIntValue(String JsonString, String JsonId) {
        int JsonValue = 0;
        if (JsonString == null || JsonString.trim().length()<1){
            return 0;
        }
        try{
            JSONObject obj1 = new JSONObject(JsonString);
            JsonValue = obj1.getInt(JsonId);
        } catch (JSONException e){
            e.printStackTrace();
        }
        return JsonValue;
    }

    // 类型 [list]
    public static String getListValue(String JsonString, String JsonId,String listId){
        String JsonValue = "";
        if (JsonString == null || JsonString.trim().length()<1){
            return null;
        }
        try{
            JSONObject obj1 = new JSONObject(JsonString);
            JsonValue = obj1.getJSONObject(JsonId).toString();
            JSONArray dataList = obj1.getJSONArray(listId) ;
            for(int i = 0;i < dataList.length();i++){
                JsonValue =(String)dataList.get(i);
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
        return JsonValue;
    }
}
