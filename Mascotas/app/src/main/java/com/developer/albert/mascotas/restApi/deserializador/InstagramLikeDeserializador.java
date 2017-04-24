package com.developer.albert.mascotas.restApi.deserializador;

import com.developer.albert.mascotas.restApi.model.InstagramLikeResponse;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


public class InstagramLikeDeserializador implements JsonDeserializer<InstagramLikeResponse> {

    public InstagramLikeResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson=new Gson();

        InstagramLikeResponse instagramLikeResponse = gson.fromJson(json, InstagramLikeResponse.class);
        JsonObject likeResponseData = json.getAsJsonObject().getAsJsonObject("meta");
        String code = likeResponseData.get("code").getAsString();
        InstagramLikeResponse like = new InstagramLikeResponse();
        like.setCode(code);
        like.setData(null);

        return like;

    }

    private InstagramLikeResponse deserializarLikeDeJson(JsonObject likeResponseData){

        InstagramLikeResponse like = new InstagramLikeResponse();
        return like;
    }












}
