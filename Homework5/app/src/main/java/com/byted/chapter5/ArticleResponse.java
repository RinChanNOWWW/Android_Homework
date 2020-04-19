package com.byted.chapter5;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class ArticleResponse {
    @SerializedName("errorCode")
    public int errorCode;
    @SerializedName("errorMsg")
    public String errorMsg;
    @SerializedName("data")
    List<Article> articles;

    public static class Article {
        //        id: 409,
        //        name: "..",
        //        order: 190001
        @SerializedName("id")
        public int id;
        @SerializedName("name")
        public String name;
        @SerializedName("order")
        public int order;

        @Override
        public String toString() {
            return "Article{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", order=" + order +
                    '}';
        }
    }
}
