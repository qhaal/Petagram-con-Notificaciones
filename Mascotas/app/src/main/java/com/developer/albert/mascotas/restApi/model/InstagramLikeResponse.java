package com.developer.albert.mascotas.restApi.model;



public class InstagramLikeResponse {


    String code;
    String data;

    public InstagramLikeResponse(String code, String data) {
        this.code = code;
        this.data = data;
    }

    public InstagramLikeResponse() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        data = data;
    }



}
