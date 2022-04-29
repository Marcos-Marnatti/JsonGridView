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
import br.edu.uniritter.mobile.nossaprimeiraapp.adapters.CommentsAdapter;
import br.edu.uniritter.mobile.nossaprimeiraapp.model.Comments;


public class CommentsActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        TextView tv = findViewById(R.id.textView5);

        tv.setText("Comments");

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/comments";

        // Request a string response from the provided URL.
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                url, null, this, this);

        // Add the request to the RequestQueue.
        queue.add(request);
    }

    @Override
    public void onResponse(JSONArray response) {

        List<Comments> lista = new ArrayList<>();

        for (int i = 0; i < response.length(); i++) {
            try {
                Log.d("onResponse: ", response.get(i).toString());

                lista.add(new Comments(response.getJSONObject(i).getString("postId"),
                        response.getJSONObject(i).getString("id"),
                        response.getJSONObject(i).getString("name"),
                        response.getJSONObject(i).getString("email"),
                        response.getJSONObject(i).getString("body")));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        CommentsAdapter cAdapt = new CommentsAdapter(lista);

        RecyclerView recyclerPosts = findViewById(R.id.rvComments);

        recyclerPosts.setAdapter(cAdapt);

        LinearLayoutManager llmPosts = new LinearLayoutManager(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);

        recyclerPosts.setLayoutManager(llmPosts);

//      rv.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}