package com.byted.chapter5;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class GsonDemo {
    public static void generateGsonString() {
        Gson gson = new Gson();
        People people = new People();
        people.age = 10;
        people.firstName = "sander";
        ArrayList<String> friends = new ArrayList<>();
        friends.add("sss");
        friends.add("ddd");
        friends.add("nnn");
        people.friends=friends;
        String s = gson.toJson(people);
        Log.d("GsonDemo", s);
    }

    public static void parseGsonString(){

        String s="[\n" +
                "    {\n" +
                "        \"name\": \"sander\",\n" +
                "        \"age\": 11\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"sander\",\n" +
                "        \"age\": 12\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"sander\",\n" +
                "        \"age\": 13\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"sander\",\n" +
                "        \"age\": 14\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"sander\",\n" +
                "        \"age\": 15\n" +
                "    }\n" +
                "]";
        Gson gson = new Gson();
        List<People> peoples = gson.fromJson(s, new TypeToken<List<People>>(){}.getType());
        Log.d("GsonDemo", peoples.toString());
    }


}
