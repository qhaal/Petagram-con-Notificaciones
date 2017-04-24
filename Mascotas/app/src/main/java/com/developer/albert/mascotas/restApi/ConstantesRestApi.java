package com.developer.albert.mascotas.restApi;

import com.developer.albert.mascotas.model.Mascota;
import com.developer.albert.mascotas.restApi.model.UsuarioResponse;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 25/05/16.
 */
public  class ConstantesRestApi {

    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    //public static final String ACCESS_TOKEN = "3259702353.aa0d0f4.e61865afc9144ecc8ffc8f6dc84aa17b";
    public static final String ACCESS_TOKEN = "4867751154.ba4c844.18fe32cc751f463e8226a430ec665412";

    //public static final String ACCESS_TOKEN = "cambiar por su propio token";

    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN

    //https://api.instagram.com/v1/users/{user-id}/media/recent/?access_token=ACCESS-TOKEN
    public static final String URL_FINAL_MEDIA_BY_ID = "users/{user-id}/media/recent/?access_token=" + ACCESS_TOKEN;
    //public static final String URL_FINAL_MEDIA_BY_ID = "users/4867751154/media/recent/?access_token=4867751154.ba4c844.18fe32cc751f463e8226a430ec665412" ;

    //https://api.instagram.com/v1/users/search?q=jack&access_token=ACCESS-TOKEN
    public static final String URL_FINAL_SEARCH = "users/search?q=jack&access_token=" + ACCESS_TOKEN;



    public static String ID_PERFIL_SELECCIONADO="";
    public static Mascota mascotaSeleccionada=null;
    public static ArrayList<Mascota> mascotasSeleccionadas=null;
    public static UsuarioResponse respuestaRegistro;





    // =======================================================================================
    // SERVIDOR HEROKU NOTIFICACIONES
    // =======================================================================================
    public static final String ROOT_URL_SERVER = "https://intense-stream-63676.herokuapp.com/";
    public static final String KEY_POST_ID_TOKEN = "token-device/";
    public static final String KEY_POST_REGISTRAR_USUARIO = "registrar-usuario/";
    public static final String KEY_POST_REGISTRAR_LIKE = "registrar-like/";
    public static final String KEY_ENVIAR_NOTIFICACION_LIKE = "notificacion-foto/{device-id}/{user-id}/{media-id}/";

    // =======================================================================================
    // LIKE INSTAGRAM
    // =======================================================================================
    // https://api.instagram.com/v1/media/{media-id}/likes?access_token=ACCESS-TOKEN
    // LIKE
    //curl -F 'access_token=ACCESS-TOKEN' \ https://api.instagram.com/v1/media/{media-id}/likes
    public static final String URL_SET_LIKE = "media/{media-id}/likes";

    //rLIKE
    //curl -X DELETE https://api.instagram.com/v1/media/{media-id}/likes?access_token=ACCESS-TOKEN
//    public static final String KEY_REMOVE_LIKE = "media/{media-id}/likes";
//    public static final String URL_REMOVE_LIKE = KEY_REMOVE_LIKE + KEY_ACCESS_TOKEN + ACCESS_TOKEN;



}
