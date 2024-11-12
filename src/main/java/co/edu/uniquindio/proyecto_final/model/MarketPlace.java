package co.edu.uniquindio.proyecto_final.model;

import java.util.LinkedList;
import java.util.List;

public class MarketPlace {
    private String nombre;
    private LinkedList<Producto> productos = new LinkedList<>();
    private LinkedList<Vendedor> vendedores = new LinkedList<>();
    private LinkedList<Publicacion> publicaciones = new LinkedList<>();

    public MarketPlace() {}

    public MarketPlace(String nombre) {
        this.nombre = nombre;
    }
    public Vendedor getVendedor(String id) {
        for (Vendedor v : vendedores) {
            if (v.getCedula().equals(id)) {
                return v;
            }
        }
        return null;
    }
    public List<Producto> getProductos(String id) {
        for (Vendedor v : vendedores) {
            if (v.getCedula().equals(id)) {
                return v.getListProducto();
            }
        }
        return null;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(LinkedList<Producto> productos) {
        this.productos = productos;
    }

    public LinkedList<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(LinkedList<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public LinkedList<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(LinkedList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
}
