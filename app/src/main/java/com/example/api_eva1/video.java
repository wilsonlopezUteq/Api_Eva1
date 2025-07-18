package com.example.api_eva1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class video {

        private String fecha;
        private String Titulo;
        private String UrlVideo1;
        private String PortadaVideo;
        private String imagen;
        private static final String URL_BASE_IMAGENES = "https://uteq.edu.ec/assets/images/newspapers/";

        // El constructor debe usar los keys correctos del JSON
        public video (JSONObject a) throws JSONException {
            // Mapea el campo "anioq" del JSON a la variable "año"
            fecha = a.getString("fecha");
            // Mapea el campo "mes" del JSON a la variable "mes"
            Titulo = a.getString("Titulo");
            // Mapea el campo "urlpw" del JSON a la variable "url" (el PDF)
            UrlVideo1 = a.getString("UrlVideo1");
            // Mapea el campo "urlportada" del JSON a la variable "imagen"
            UrlVideo1 = a.getString("UrlVideo1");

            PortadaVideo = a.getString("PortadaVideo");
        }

        // El resto de la clase está bien...
        public static <Video> ArrayList<video> JsonObjectsBuild(JSONArray datos) throws JSONException {
            ArrayList<Video> Video = new ArrayList<>();
            for (int i = 0; i < datos.length(); i++) {
                Video.add((Video) new video(datos.getJSONObject(i)));
            }
            return (ArrayList<video>) Video;
        }

        public String getfecha() {
            return fecha;
        }

        public void setAño(String Titulo) {
            this.Titulo = Titulo;
        }

        public String getUrlVideo1() {
            return  UrlVideo1;
        }

        public void setPortadaVideo(String PortadaVideo) {
            this.PortadaVideo = PortadaVideo;
        }


        public String getImagen() {
            return imagen;
        }


    }
}
