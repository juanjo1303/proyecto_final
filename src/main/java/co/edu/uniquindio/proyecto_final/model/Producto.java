package co.edu.uniquindio.proyecto_final.model;

public class Producto {
    private String nombre;
    private String imagen;
    private double precio;
    private String categoria;
    private Estado estado;
    private Publicacion publicacion;

    public Producto() {
    }

    public Producto(String nombre, Estado estado, String categoria, double precio, String imagen, Publicacion publicacion) {
        this.nombre = nombre;
        this.estado = estado;
        this.categoria = categoria;
        this.precio = precio;
        this.imagen = imagen;
        this.publicacion = publicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
}
