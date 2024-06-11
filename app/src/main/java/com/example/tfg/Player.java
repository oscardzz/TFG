package com.example.tfg;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable {
    private String nombre;
    private String equipo;
    private String posicion;
    private String nacionalidad;
    private String img;

    public Player() {
        // Constructor vacío necesario para Firebase
    }

    public Player(String nombre, String equipo, String posicion, String nacionalidad, String img) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.posicion = posicion;
        this.nacionalidad = nacionalidad;
        this.img = img;
    }

    // Getters y setters

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEquipo() { return equipo; }
    public void setEquipo(String equipo) { this.equipo = equipo; }
    public String getPosicion() { return posicion; }
    public void setPosicion(String posicion) { this.posicion = posicion; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }

    // Parcelable implementation
    protected Player(Parcel in) {
        nombre = in.readString();
        equipo = in.readString();
        posicion = in.readString();
        nacionalidad = in.readString();
        img = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(equipo);
        dest.writeString(posicion);
        dest.writeString(nacionalidad);
        dest.writeString(img);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };
}
