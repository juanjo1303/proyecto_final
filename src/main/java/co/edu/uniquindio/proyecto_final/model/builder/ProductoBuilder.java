package co.edu.uniquindio.proyecto_final.model.builder;

import co.edu.uniquindio.proyecto_final.model.EEstado;
import co.edu.uniquindio.proyecto_final.model.Producto;

public class ProductoBuilder {
    public String nombre;
    public String imagen;
    public String categoria;
    public String precio;
    public EEstado estado;

    public ProductoBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public ProductoBuilder imagen(String imagen) {
        this.imagen = imagen;
        return this;
    }
    public ProductoBuilder categoria(String categoria) {
        this.categoria = categoria;
        return this;
    }
    public ProductoBuilder precio(String precio) {
        this.precio = precio;
        return this;
    }
    public ProductoBuilder estado(EEstado estado) {
        this.estado = estado;
        return this;
    }
    public Producto build() {return new Producto(
            nombre,
            imagen,
            categoria,
            precio,
            estado);}
}
