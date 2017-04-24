package com.developer.albert.mascotas.adapter;

import android.app.Activity;
import android.content.ContentValues;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.albert.mascotas.db.ConstantesBaseDatos;
import com.developer.albert.mascotas.model.ConstructorMascotas;
import com.developer.albert.mascotas.model.Mascota;
import com.developer.albert.mascotas.R;
import com.developer.albert.mascotas.restApi.ConstantesRestApi;
import com.developer.albert.mascotas.restApi.EndpointsApi;
import com.developer.albert.mascotas.restApi.adapter.RestApiAdapter;
import com.developer.albert.mascotas.restApi.model.FirebaseRegistrarFoto;
import com.developer.albert.mascotas.restApi.model.InstagramLikeResponse;
import com.developer.albert.mascotas.restApi.model.MascotaResponse;
import com.developer.albert.mascotas.restApi.model.UsuarioResponse;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Albert on 4/03/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;


    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    // Inflar el layout  y la pasara el viewHolder para que obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(view);
    }
    // Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, final int position) {


        final Mascota mascota = mascotas.get(position);
        //holder.imgFoto.setImageResource(mascota.getFoto());
        Picasso.with(activity)
                .load(mascota.getFoto())
                .placeholder(R.drawable.mascota_1)
                .into(holder.imgFoto);
        //holder.tvNombreMascota.setText(mascota.getNombreMascota());
        holder.tvLikes.setText(""+mascota.getLikes());

        holder.imgHuesoAmarillo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

//REGISTRANDO LIKE
                RestApiAdapter restApiAdapter = new RestApiAdapter();
                EndpointsApi endponits = restApiAdapter.establecerConexionRestAPIServer();
                Call<FirebaseRegistrarFoto> usuarioResponseCall = endponits.registrarFoto(FirebaseInstanceId.getInstance().getToken().toString(),
                        mascota.getId(),
                        mascota.getFoto());
                //Call<FirebaseRegistrarFoto> usuarioResponseCall = endponits.registrarFoto("id","dispo","foto");


                usuarioResponseCall.enqueue(new Callback<FirebaseRegistrarFoto>() {
                    @Override
                    public void onResponse(Call<FirebaseRegistrarFoto> call, Response<FirebaseRegistrarFoto> response) {
                        FirebaseRegistrarFoto firebaseRegistrarFoto = response.body();
                        Log.d("ID_DISPOSITIVO", "" +firebaseRegistrarFoto.getId_dispositivo());
                        Log.d("ID_INSTAGRAM","" + firebaseRegistrarFoto.getId_usuario_instagram());
                        Log.d("ID_FOTO_MEDIA","" + firebaseRegistrarFoto.getId_foto_media());
                        Toast.makeText(activity,"Diste un Like", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<FirebaseRegistrarFoto> call, Throwable t) {

                    }
                });
//ENVIANDO NOTIFICACION
                RestApiAdapter restApiAdapter2 = new RestApiAdapter();
                EndpointsApi endponits2 = restApiAdapter2.establecerConexionRestAPIServer();
                Call<UsuarioResponse> usuarioResponseCall2 =
                        endponits2.enviarNotificaionLike(ConstantesRestApi.respuestaRegistro.getId(), //id autogenerado
                                ConstantesRestApi.respuestaRegistro.getId_dispositivo(),
                                ConstantesRestApi.respuestaRegistro.getId_usuario_instagram());

                usuarioResponseCall2.enqueue(new Callback<UsuarioResponse>() {
                    @Override
                    public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                        UsuarioResponse firebaseRegistrarFoto = response.body();
                        Log.d("Noti_ID_DISPOSITIVO", "" +firebaseRegistrarFoto.getId());
                        Log.d("Noti_ID_INSTAGRAM","" + firebaseRegistrarFoto.getId_dispositivo());
                        Log.d("Noti_ID_FOTO_MEDIA","" + firebaseRegistrarFoto.getId_usuario_instagram());
                        Toast.makeText(activity,"Notificacion Enviada", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<UsuarioResponse> call, Throwable t) {

                    }
                });

//REGISTRANDO LIKE EN INSTAGRAM
                //Aqui se insrtara un like a la imagenen instagram

                RestApiAdapter instagramRestApiAdapter = new RestApiAdapter();
                Gson gsonLike = instagramRestApiAdapter.construyeGsonDeserializadorLike();
                EndpointsApi instagramEndpointsApi = instagramRestApiAdapter.establecerConexionRestApiInstagram(gsonLike);
                Call<InstagramLikeResponse> likeResponseCall =
                        instagramEndpointsApi.setLikeMedia(FirebaseInstanceId.getInstance().getToken().toString(), mascota.getFoto());
                likeResponseCall.enqueue(new Callback<InstagramLikeResponse>() {
                    @Override
                    public void onResponse(Call<InstagramLikeResponse> call, Response<InstagramLikeResponse> response) {
                        InstagramLikeResponse instagramLikeResponse = response.body();
//                Log.e("ADAPTER MASCOTA","insertarlike" + instagramLikeResponse.getCode());
                        // /nuevasMascotas = instagramMascotaResponse.getMascotas();
                        //añadirMascotas();
                    }
                    @Override
                    public void onFailure(Call<InstagramLikeResponse> call, Throwable t) {
                        //Toast.makeText(getContext,"Fallo con la conexion cargando Fotos en el Principal",Toast.LENGTH_SHORT).show();

                    }
                });






                //notifyItemChanged(holderTemporal.getAdapterPosition());
                //Toast.makeText(activity,position + "", Toast.LENGTH_SHORT).show();
//                int puntuacionTemporal;
//                puntuacionTemporal = Integer.parseInt(holder.tvPuntuacion.getText().toString());
//                puntuacionTemporal = puntuacionTemporal + 1;
//                holder.tvPuntuacion.setText("" + puntuacionTemporal);
//
//                ContentValues contentValues = new ContentValues();
//                contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_PUNTUACION, puntuacionTemporal);
//
//                ConstructorMascotas constructorContactos = new ConstructorMascotas(activity);
//                constructorContactos.actualizarPuntuacionMascota(mascota,contentValues);

            }
        });
    }
    // catidad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        //private TextView tvNombreMascota;
        private TextView tvLikes;
        private ImageView imgHuesoAmarillo;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            //tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvLikes = (TextView) itemView.findViewById(R.id.tvPuntuacion);
            imgHuesoAmarillo = (ImageView) itemView.findViewById(R.id.imgHuesoAmarillo);

        }
    }

}
