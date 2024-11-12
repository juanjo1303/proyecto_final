package co.edu.uniquindio.proyecto_final.mapping.dto;

import co.edu.uniquindio.proyecto_final.model.Estado;
import javafx.scene.image.Image;

public class ProductoDto {
    public String nombre;
    public Image imagen;
    public String categoria;
    public String precio;
    public Estado estado;

    public ProductoDto() {}

    public ProductoDto(String nombre, String rutaImagen, String categoria, String precio) {
        this.nombre = nombre;
        this.imagen = new Image(getClass().getResource(rutaImagen).toString());
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
