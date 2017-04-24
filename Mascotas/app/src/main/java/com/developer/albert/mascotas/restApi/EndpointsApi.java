package com.developer.albert.mascotas.restApi;


import com.developer.albert.mascotas.restApi.model.FirebaseRegistrarFoto;
import com.developer.albert.mascotas.restApi.model.InstagramLikeResponse;
import com.developer.albert.mascotas.restApi.model.MascotaResponse;
import com.developer.albert.mascotas.restApi.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Albert on 20/04/17.
 */
public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();


    @GET(ConstantesRestApi.URL_FINAL_SEARCH)
    Call<MascotaResponse> getRecentMediaBusqueda(@Query("q") String perfil);


    @GET(ConstantesRestApi.URL_FINAL_MEDIA_BY_ID)
    Call<MascotaResponse> getRecentMediaByID(@Path("user-id") String id);

    // ==============================================================================
    // SERVIDOR HEROKU Y NOTIFICACIONES
    // ==============================================================================
    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_REGISTRAR_USUARIO)
    Call<UsuarioResponse> registrarTokenIDServer(@Field("id_dispositivo") String token, @Field("id_usuario_instagram") String animal);


    // ==============================================================================
    // registrar like
    // ==============================================================================
    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_REGISTRAR_LIKE)
    Call<FirebaseRegistrarFoto> registrarFoto(@Field("id_dispositivo") String id_dispositivo,@Field("id_usuario_instagram") String id_usuario_instagram,@Field("id_foto_media") String id_foto);
   // app.get('/notificacion-foto/:idGenerado/:idUserInstagram/:idFoto',function(request,response){

    @GET(ConstantesRestApi.KEY_ENVIAR_NOTIFICACION_LIKE)
    Call<UsuarioResponse> enviarNotificaionLike(@Path("device-id") String deviceId,
                                                      @Path("user-id") String userId,
                                                      @Path("media-id") String idFoto);


    //LIKES
    @FormUrlEncoded
    @POST(ConstantesRestApi.URL_SET_LIKE)
    Call<InstagramLikeResponse> setLikeMedia(@Field("access_token") String ACCESS_TOKEN,
                                             @Path("media-id")String mediaId);
}
