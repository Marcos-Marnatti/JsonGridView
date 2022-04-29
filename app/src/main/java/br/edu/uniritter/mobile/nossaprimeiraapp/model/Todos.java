package br.edu.uniritter.mobile.nossaprimeiraapp.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Todos implements Parcelable {
    private String userId;
    private String id;
    private String title;
    private boolean completed;

    public Todos(String userId, String id, String title, boolean completed){
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;

    }

    protected Todos(Parcel in) {
        userId = in.readString();
        id = in.readString();
        title = in.readString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            completed = in.readBoolean();
        }
    }

    public static final Creator<Todos> CREATOR = new Creator<Todos>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Todos createFromParcel(Parcel in) {
            return new Todos(in);
        }

        @Override
        public Todos[] newArray(int size) {
            return new Todos[size];
        }
    };

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object t) {
        if (this == t) return true;
        if (t == null || getClass() != t.getClass()) return false;
        Todos todo = (Todos) t;
        return userId == todo.userId && Objects.equals(id, todo.id) && Objects.equals(title, todo.title) && Objects.equals(completed, todo.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, id, title, completed);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getUserId());
        parcel.writeString(getId());
        parcel.writeString(getTitle());
        parcel.writeBoolean(isCompleted());

    }
}


