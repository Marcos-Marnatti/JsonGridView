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
import br.edu.uniritter.mobile.nossaprimeiraapp.adapters.PostsAdapter;
import br.edu.uniritter.mobile.nossaprimeiraapp.model.Posts;


public class PostsActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        TextView tv = findViewById(R.id.textView4);

        tv.setText("Posts");

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/posts";

        // Request a string response from the provided URL.
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                url, null, this, this);

        // Add the request to the RequestQueue.
        queue.add(request);
    }

    @Override
    public void onResponse(JSONArray response) {

        List<Posts> lista = new ArrayList<>();

        for (int i = 0; i < response.length(); i++) {
            try {
                Log.d("onResponse: ", response.get(i).toString());

                lista.add(new Posts(response.getJSONObject(i).getString("userId"),
                        response.getJSONObject(i).getString("id"),
                        response.getJSONObject(i).getString("title"),
                        response.getJSONObject(i).getString("body")));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        PostsAdapter pAdapt = new PostsAdapter(lista);

        RecyclerView recyclerPosts = findViewById(R.id.rvPost);

        recyclerPosts.setAdapter(pAdapt);

        LinearLayoutManager llmPosts = new LinearLayoutManager(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);

        recyclerPosts.setLayoutManager(llmPosts);

//      rv.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
