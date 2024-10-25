package co.edu.uniquindio.proyecto_final.model;

import java.util.LinkedList;

public class Publicacion {
    private Producto producto;
    private LinkedList<Comentario> comentarios = new LinkedList<>();

    public Publicacion(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
