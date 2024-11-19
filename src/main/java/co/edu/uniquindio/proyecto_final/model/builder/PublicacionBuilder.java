package co.edu.uniquindio.proyecto_final.model.builder;

import co.edu.uniquindio.proyecto_final.model.Comentario;
import co.edu.uniquindio.proyecto_final.model.Producto;
import co.edu.uniquindio.proyecto_final.model.Publicacion;
import co.edu.uniquindio.proyecto_final.model.Vendedor;

import java.util.LinkedList;

public class PublicacionBuilder {
    private Vendedor vendedor;
    private Producto producto;
    private String descripcion;
    private LinkedList<Comentario> comentarios = new LinkedList<>();

    public PublicacionBuilder vendedor(Vendedor vendedor) {
        this.vendedor  = vendedor;
        return this;
    }

    public PublicacionBuilder producto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public PublicacionBuilder descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public PublicacionBuilder comentarios(LinkedList<Comentario> comentarios) {
        this.comentarios = comentarios;
        return this;
    }

    public Publicacion build() {return new Publicacion(vendedor,producto,descripcion);}

}
