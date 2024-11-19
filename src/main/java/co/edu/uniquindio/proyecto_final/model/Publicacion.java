package co.edu.uniquindio.proyecto_final.model;

import co.edu.uniquindio.proyecto_final.model.builder.PublicacionBuilder;

import java.util.LinkedList;

public class Publicacion {
    private Vendedor vendedor;
    private Producto producto;
    private String descripcion;
    private LinkedList<Comentario> comentarios = new LinkedList<>();

    public Publicacion(Vendedor vendedor, Producto producto, String descripcion) {
        this.vendedor = vendedor;
        this.producto = producto;
        this.descripcion = descripcion;
        this.comentarios = new LinkedList<>();
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LinkedList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(LinkedList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public static PublicacionBuilder builder() {
        return new PublicacionBuilder();
    }
}
