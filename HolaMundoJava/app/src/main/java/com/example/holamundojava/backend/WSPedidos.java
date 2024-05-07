package com.example.holamundojava.backend;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WSPedidos {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("usuario_id")
    @Expose
    private String usuarioId;
    @SerializedName("producto_id")
    @Expose
    private String productoId;
    @SerializedName("cantidad")
    @Expose
    private String cantidad;
    @SerializedName("fecha_pedido")
    @Expose
    private String fechaPedido;

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
    public String getCantidad() {
        return cantidad;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    public String getFechaPedido() {
        return fechaPedido;
    }
    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
}