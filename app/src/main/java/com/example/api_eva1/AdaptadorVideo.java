package com.example.api_eva1;
import android.content.Context;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdaptadorVideo
{
    // Debe extender ArrayAdapter<Video>
    public class adaptadorVideo extends ArrayAdapter<MediaStore.Video> {

        private static final String URL_BASE_IMAGENES = "https://uteq.edu.ec/assets/images/newspapers/";

        public adaptadorVideo(Context context, ArrayList<video> datos) {
            super(context, R.layout.item, datos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.item, null);

            // Obtener la revista actual
            MediaStore.Video video = getItem(position);

            TextView tvfecha = (TextView) item.findViewById(R.id.tvfecha);
            tvfecha.setText(MediaStore.Video.getfecha());

            TextView tvTitulo = (TextView) item.findViewById(R.id.tvTitulo);
            tvTitulo.setText(MediaStore.Video.getTitulo());

            TextView tvUrlVideo1 = (TextView) item.findViewById(R.id.tvUrlVideo1);
            tvUrlVideo1.setText(MediaStore.Video.getUrlVideo1());

            TextView tvPortadaVideo = (TextView) item.findViewById(R.id.tvPortadaVideo);
            tvPortadaVideo.setText(MediaStore.Video.getPortadaVideo());

            ImageView imageView = (ImageView) item.findViewById(R.id.imgVideo);


            String urlCompleta = URL_BASE_IMAGENES + com.example.api_eva1.video.getImagen();

            Glide.with(getContext())
                    .load(urlCompleta)
                    .into(imageView);

            return item;
        }
    }
}
