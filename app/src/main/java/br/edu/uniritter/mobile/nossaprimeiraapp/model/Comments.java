package br.edu.uniritter.mobile.nossaprimeiraapp.model;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Comments implements Parcelable {
    private String postIdc;
    private String idc;
    private String namec;
    private String emailc;
    private String bodyc;

    public Comments(String postId, String id, String name, String email, String body){
        this.postIdc = postId;
        this.idc = id;
        this.namec = name;
        this.emailc = email;
        this.bodyc = body;

    }

    protected Comments(Parcel in) {
        postIdc = in.readString();
        idc = in.readString();
        namec = in.readString();
        emailc = in.readString();
        bodyc = in.readString();
    }

    public static final Creator<Comments> CREATOR = new Creator<Comments>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Comments createFromParcel(Parcel in) {
            return new Comments(in);
        }

        @Override
        public Comments[] newArray(int size) {
            return new Comments[size];
        }
    };

    public String getPostIdc() { return postIdc; }
    public String getIdc() {
        return idc;
    }
    public String getNamec() {
        return namec;
    }
    public String getBodyc() {
        return bodyc;
    }
    public String getEmailc() {
        return emailc;
    }



    @Override
    public int hashCode() {
        return Objects.hash(postIdc, idc, namec, bodyc,emailc);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getPostIdc());
        parcel.writeString(getIdc());
        parcel.writeString(getNamec());
        parcel.writeString(getBodyc());
        parcel.writeString(getEmailc());


    }
}