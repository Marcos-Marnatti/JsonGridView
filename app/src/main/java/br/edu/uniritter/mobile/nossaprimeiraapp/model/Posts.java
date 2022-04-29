package br.edu.uniritter.mobile.nossaprimeiraapp.model;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Posts implements Parcelable {
    private String userId;
    private String id;
    private String title;
    private String body;

    public Posts(String userId, String id, String title, String body){
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;

    }

    protected Posts(Parcel in) {
        userId = in.readString();
        id = in.readString();
        title = in.readString();
        body = in.readString();
    }

    public static final Creator<Posts> CREATOR = new Creator<Posts>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Posts createFromParcel(Parcel in) {
            return new Posts(in);
        }

        @Override
        public Posts[] newArray(int size) {
            return new Posts[size];
        }
    };

    public String getUserId() { return userId; }

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    @Override
    public int hashCode() {
        return Objects.hash(userId, id, title, body);
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
        parcel.writeString(getBody());

    }
}