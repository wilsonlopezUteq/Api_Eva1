package com.example.api_eva1;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;


    public class MainActivity extends AppCompatActivity implements Asynchtask {

        private ListView lstvideo;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            Map<String, String> datos = new HashMap<String, String>();
            WebService ws= new WebService("https://apiws.uteq.edu.ec/h6RPoSoRaah0Y4Bah28eew/functions/information/entity/5",
                    datos, MainActivity.this, MainActivity.this);
            ws.execute("GET","Bearer ", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJfeDF1c2VyZGV2IiwiaWF0IjoxNzUyODY4NjIwLCJleHAiOjE3NTI5NTUwMjB9.tZPdC3XwEOhgHZz_QFk5TQa2SrFXimlgVSFa6cwhiwY");

        }


        @Override
        public void processFinish(String result) throws JSONException {

            ListView lstListaUsuario = (ListView)findViewById(R.id.lstproductos);

            //JSONObject JSONlista =  new JSONObject(result);
            // JSONArray JSONlistaUsurious=  JSONlista.getJSONArray("data");

            JSONArray JSONlistaUsuarios=  new JSONArray(result);

            ArrayList<MediaStore.Video> lstvideo = video.JsonObjectsBuild(JSONlistaUsuarios);

            AdaptadorVideo adapatorVideo= new AdaptadorVideo(this, lstvideo);

            lstListaUsuario.setAdapter(adapatorVideo);



    }