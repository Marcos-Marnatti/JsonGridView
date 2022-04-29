package br.edu.uniritter.mobile.nossaprimeiraapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import br.edu.uniritter.mobile.nossaprimeiraapp.R;

public class MainActivity extends AppCompatActivity {

    private Button bt_users, bt_albums, bt_todo, bt_photo, bt_posts, bt_comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startComponents();

        bt_users.setOnClickListener(v -> startActivity(new Intent (MainActivity.this, UserActivity.class)));
        bt_todo.setOnClickListener(v -> startActivity(new Intent (MainActivity.this, TodoActivity.class)));
        bt_posts.setOnClickListener(v -> startActivity(new Intent (MainActivity.this, PostsActivity.class)));
        bt_comments.setOnClickListener(v -> startActivity(new Intent (MainActivity.this, CommentsActivity.class)));
        bt_photo.setOnClickListener(v -> startActivity(new Intent (MainActivity.this, PhotosActivity.class)));
        bt_albums.setOnClickListener(v -> startActivity(new Intent (MainActivity.this, AlbumsActivity.class)));


    }

    private void startComponents() {
        bt_users = findViewById(R.id.bt_users);
        bt_albums = findViewById(R.id.bt_albums);
        bt_todo = findViewById(R.id.bt_todo);
        bt_photo = findViewById(R.id.bt_photo);
        bt_posts = findViewById(R.id.bt_posts);
        bt_comments = findViewById(R.id.bt_comments);
    }
}