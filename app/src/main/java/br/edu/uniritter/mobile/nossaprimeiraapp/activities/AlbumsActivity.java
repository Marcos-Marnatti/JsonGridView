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
import org.w3c.dom.Comment;


import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.nossaprimeiraapp.R;
import br.edu.uniritter.mobile.nossaprimeiraapp.adapters.AlbumsAdapter;
import br.edu.uniritter.mobile.nossaprimeiraapp.adapters.CommentsAdapter;
import br.edu.uniritter.mobile.nossaprimeiraapp.model.Albums;
import br.edu.uniritter.mobile.nossaprimeiraapp.model.Comments;


public class AlbumsActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        TextView tv = findViewById(R.id.textView9);

        tv.setText("Albums");

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/albums";

        // Request a string response from the provided URL.
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                url, null, this, this);

        // Add the request to the RequestQueue.
        queue.add(request);
    }

    @Override
    public void onResponse(JSONArray response) {

        List<Albums> lista = new ArrayList<>();

        for (int i = 0; i < response.length(); i++) {
            try {
                Log.d("onResponse: ", response.get(i).toString());

                lista.add(new Albums(response.getJSONObject(i).getString("userId"),
                        response.getJSONObject(i).getString("id"),
                        response.getJSONObject(i).getString("title")));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        AlbumsAdapter cAdapt = new AlbumsAdapter(lista);

        RecyclerView recyclerAlbums = findViewById(R.id.rvAlbums);

        recyclerAlbums.setAdapter(cAdapt);

        LinearLayoutManager llmAlbums = new LinearLayoutManager(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);

        recyclerAlbums.setLayoutManager(llmAlbums);

//      rv.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}