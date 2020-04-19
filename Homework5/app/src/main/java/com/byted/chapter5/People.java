package com.byted.chapter5;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class People {
    @SerializedName("age")
    public int age;
    @SerializedName("name")
    public String firstName;
    @SerializedName("friends")
    public List<String> friends;

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", friends=" + friends +
                '}';
    }
}
