package com.developer.albert.mascotas.restApi.model;

/**
 * Created by albert on 20/4/17.
 */

public class FirebaseRegistrarFoto {


    private String id_dispositivo;
    private String id_usuario_instagram;
    private String id_foto_media;

    public FirebaseRegistrarFoto(String id_dispositivo, String id_usuario_instagram, String id_foto_media) {
        this.id_dispositivo = id_dispositivo;
        this.id_usuario_instagram = id_usuario_instagram;
        this.id_foto_media = id_foto_media;
    }

    public String getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public String getId_usuario_instagram() {
        return id_usuario_instagram;
    }

    public void setId_usuario_instagram(String id_usuario_instagram) {
        this.id_usuario_instagram = id_usuario_instagram;
    }

    public String getId_foto_media() {
        return id_foto_media;
    }

    public void setId_foto_media(String id_foto_media) {
        this.id_foto_media = id_foto_media;
    }
}
