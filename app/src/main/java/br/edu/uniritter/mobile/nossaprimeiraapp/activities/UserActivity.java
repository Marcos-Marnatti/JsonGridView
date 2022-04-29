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
import br.edu.uniritter.mobile.nossaprimeiraapp.adapters.UsersAdapter;
import br.edu.uniritter.mobile.nossaprimeiraapp.model.Users;

public class UserActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        TextView tv = findViewById(R.id.textView2);

        tv.setText("Users");

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://jsonplaceholder.typicode.com/users";

        // Request a string response from the provided URL.
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                url, null,this, this);

        // Add the request to the RequestQueue.
        queue.add(request);
    }

    @Override
    public void onResponse(JSONArray response) {

        List<Users> lista = new ArrayList<>();

        for (int i = 0; i < response.length(); i++) {
            try {
                Log.d("onResponse: ", response.get(i).toString());

                lista.add(new Users(response.getJSONObject(i).getString("id"),
                        response.getJSONObject(i).getString("name"),
                        response.getJSONObject(i).getString("username"),
                        response.getJSONObject(i).getString("email")));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        UsersAdapter uAdapt = new UsersAdapter(lista);

        RecyclerView recyclerUsers = findViewById(R.id.rvUsers);

        recyclerUsers.setAdapter(uAdapt);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);

        recyclerUsers.setLayoutManager(llm);

//      rv.setLayoutManager(gridLayoutManager);

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}