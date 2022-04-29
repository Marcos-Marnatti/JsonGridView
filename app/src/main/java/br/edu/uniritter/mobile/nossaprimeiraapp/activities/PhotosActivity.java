package br.edu.uniritter.mobile.nossaprimeiraapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;


import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.nossaprimeiraapp.R;
import br.edu.uniritter.mobile.nossaprimeiraapp.adapters.PhotosAdapter;
import br.edu.uniritter.mobile.nossaprimeiraapp.model.Photos;



public class PhotosActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        TextView tv = findViewById(R.id.textView13);

        tv.setText("Photos");

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/photos";

        // Request a string response from the provided URL.
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                url, null, this, this);

        // Add the request to the RequestQueue.
        queue.add(request);
    }

    @Override
    public void onResponse(JSONArray response) {

        List<Photos> lista = new ArrayList<>();

        for (int i = 0; i < response.length(); i++) {
            try {
                Log.d("onResponse: ", response.get(i).toString());

                lista.add(new Photos(response.getJSONObject(i).getString("albumId"),
                        response.getJSONObject(i).getString("id"),
                        response.getJSONObject(i).getString("title"),
                        response.getJSONObject(i).getString("url"),
                        response.getJSONObject(i).getString("thumbnailUrl")));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        PhotosAdapter pasAdapt = new PhotosAdapter(lista);

        RecyclerView recyclerPhotos = findViewById(R.id.rvPhotos);

        recyclerPhotos.setAdapter(pasAdapt);

        LinearLayoutManager llmPhotos = new LinearLayoutManager(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);

        recyclerPhotos.setLayoutManager(llmPhotos);

//      rv.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
