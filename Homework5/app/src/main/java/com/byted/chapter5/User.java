package com.byted.chapter5;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * "admin": false,
 * "chapterTops": [],
 * "collectIds": [],
 * "email": "",
 * "icon": "",
 * "id": 58872,
 * "nickname": "wwwsjdajsd",
 * "password": "",
 * "publicName": "wwwsjdajsd",
 * "token": "",
 * "type": 0,
 * "username": "wwwsjdajsd"
 */
class User {
    @SerializedName("admin")
    public String admin;
    @SerializedName("email")
    public String email;
    @SerializedName("icon")
    public String icon;
    @SerializedName("id")
    public int id;
    @SerializedName("nickname")
    public String nickname;
    @SerializedName("password")
    public String password;
    @SerializedName("publicName")
    public String publicName;
    @SerializedName("token")
    public String token;
    @SerializedName("type")
    public int type;
    @SerializedName("username")
    public String username;

}
