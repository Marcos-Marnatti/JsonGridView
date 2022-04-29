package br.edu.uniritter.mobile.nossaprimeiraapp.model;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Photos implements Parcelable {
    private String albumIdph;
    private String idph;
    private String tittleph;
    private String urlph;
    private String thumbnailph;


    public Photos(String albumIdph, String idph, String tittleph, String urlph, String thumbnailph){
        this.albumIdph = albumIdph;
        this.idph = idph;
        this.tittleph = tittleph;
        this.urlph = urlph;
        this.thumbnailph = thumbnailph;

    }

    protected Photos(Parcel in) {
        albumIdph = in.readString();
        idph = in.readString();
        tittleph = in.readString();
        urlph = in.readString();
        thumbnailph = in.readString();
    }

    public static final Creator<Photos> CREATOR = new Creator<Photos>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Photos createFromParcel(Parcel in) {
            return new Photos(in);
        }

        @Override
        public Photos[] newArray(int size) {
            return new Photos[size];
        }
    };

    public String getAlbumIdph() { return albumIdph; }
    public String getIdph() {
        return idph;
    }
    public String getTittleph() {
        return tittleph;
    }
    public String getUrlph() {
        return urlph;
    }
    public String getThumbnailph() {
        return thumbnailph;
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumIdph, idph, tittleph,urlph,thumbnailph);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getAlbumIdph());
        parcel.writeString(getIdph());
        parcel.writeString(getTittleph());
        parcel.writeString(getUrlph());
        parcel.writeString(getThumbnailph());

    }
}