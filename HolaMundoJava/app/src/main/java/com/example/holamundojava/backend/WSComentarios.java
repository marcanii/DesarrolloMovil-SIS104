package com.example.holamundojava.backend;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WSComentarios {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("usuario_id")
    @Expose
    private String usuarioId;
    @SerializedName("producto_id")
    @Expose
    private String productoId;
    @SerializedName("comentario")
    @Expose
    private String comentario;
    @SerializedName("fecha_comentario")
    @Expose
    private String fechaComentario;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
    public String getProductoId() {
        return productoId;
    }
    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public String getFechaComentario() {
        return fechaComentario;
    }
    public void setFechaComentario(String fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
}