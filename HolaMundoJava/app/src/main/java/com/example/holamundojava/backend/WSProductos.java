package com.example.holamundojava.backend;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WSProductos {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("precio")
    @Expose
    private String precio;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("categoria")
    @Expose
    private String categoria;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}