package br.edu.uniritter.mobile.nossaprimeiraapp.model;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Albums implements Parcelable {
    private String userIda;
    private String ida;
    private String tittlea;


    public Albums(String userIda, String ida, String tittlea){
        this.userIda = userIda;
        this.ida = ida;
        this.tittlea = tittlea;

    }

    protected Albums(Parcel in) {
        userIda = in.readString();
        ida = in.readString();
        tittlea = in.readString();
    }

    public static final Creator<Albums> CREATOR = new Creator<Albums>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Albums createFromParcel(Parcel in) {
            return new Albums(in);
        }

        @Override
        public Albums[] newArray(int size) {
            return new Albums[size];
        }
    };

    public String getUserIda() { return userIda; }
    public String getIda() {
        return ida;
    }
    public String getTittlea() {
        return tittlea;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userIda, ida, tittlea);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getUserIda());
        parcel.writeString(getIda());
        parcel.writeString(getTittlea());

    }
}