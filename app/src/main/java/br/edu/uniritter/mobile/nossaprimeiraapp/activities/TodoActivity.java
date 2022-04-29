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
import br.edu.uniritter.mobile.nossaprimeiraapp.adapters.TodosAdapter;
import br.edu.uniritter.mobile.nossaprimeiraapp.model.Todos;

public class TodoActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        TextView tv = findViewById(R.id.textView3);

        tv.setText("To Dos");

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://jsonplaceholder.typicode.com/todos";

        // Request a string response from the provided URL.
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                url, null,this, this);

        // Add the request to the RequestQueue.
        queue.add(request);
    }

    @Override
    public void onResponse(JSONArray response) {

        List<Todos> lista = new ArrayList<>();

        for (int i = 0; i < response.length(); i++) {
            try {
                Log.d("onResponse: ", response.get(i).toString());

                lista.add(new Todos(response.getJSONObject(i).getString("userId"),
                        response.getJSONObject(i).getString("id"),
                        response.getJSONObject(i).getString("title"),
                        response.getJSONObject(i).getBoolean("completed")));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        TodosAdapter tAdapt = new TodosAdapter(lista);

        RecyclerView recyclerTodos = findViewById(R.id.rvTodo);

        recyclerTodos.setAdapter(tAdapt);

        LinearLayoutManager llmTodo = new LinearLayoutManager(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);

        recyclerTodos.setLayoutManager(llmTodo);

//      rv.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}