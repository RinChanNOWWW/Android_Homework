package com.byted.chapter5;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonDemo {

//    {
//        "temp":{
//              "min":11.34,
//              "max":19.01
//         },
//        "weather":{
//               "id":801,
//               "condition":"Clouds",
//               "description":null
//         },
//        "success":true,
//        "notification_user_id": [
//                "Adam",
//                "Bob",
//                "John"
//          ]
//    }

    public static void generateJsonString() {
        try {
            JSONObject jsonObject = new JSONObject();
            JSONObject tempJson = new JSONObject();
            tempJson.put("min", 11.34);
            tempJson.put("max", 19.01);
            jsonObject.put("temp", tempJson);
            jsonObject.put("success", true);
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("Adam");
            jsonArray.put("Bob");
            jsonArray.put("John");
            jsonObject.put("notification_user_id", jsonArray);
            Log.d("JsonDemo", jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static void parseJsonString() {
        String s = "{\"temp\":{\"min\":11.34,\"max\":19.01},\"success\":true,\"notification_user_id\":[\"Adam\",\"Bob\",\"John\"]}";
        try {
            JSONObject jsonObject = new JSONObject(s);
//            JSONObject temp = jsonObject.getJSONObject("temp");
//            double min = temp.getDouble("min");
            JSONArray notificationUserId = jsonObject.getJSONArray("notification_user_id");

            boolean success = jsonObject.optBoolean("unexist",true);
            boolean unexist = jsonObject.getBoolean("unexist");
            Log.d("JsonDemo", "success:" + unexist);
        } catch (JSONException e) {
            Log.d("JsonDemo", "crash:"+e.getMessage());
            e.printStackTrace();
        }
    }
}
