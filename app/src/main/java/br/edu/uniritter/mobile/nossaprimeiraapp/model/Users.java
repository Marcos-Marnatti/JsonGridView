package br.edu.uniritter.mobile.nossaprimeiraapp.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Users implements Parcelable {
    private String id;
    private String name;
    private String username;
    private String email;

    public Users(String id, String name, String username, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }

    protected Users(Parcel in) {
        id = in.readString();
        username = in.readString();
        email = in.readString();
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };

    public String getId() {
        return id;
    }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }


    @Override
    public boolean equals(Object u) {
        if (this == u) return true;
        if (u == null || getClass() != u.getClass()) return false;
        Users users = (Users) u;
        return id == users.id && Objects.equals(name, users.name) && Objects.equals(username, users.username) && Objects.equals(email, users.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, email);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getId());
        parcel.writeString(getName());
        parcel.writeString(getUsername());
        parcel.writeString(getEmail());

    }
}