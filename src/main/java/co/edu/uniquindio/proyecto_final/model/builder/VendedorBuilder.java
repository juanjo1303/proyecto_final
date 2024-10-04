package co.edu.uniquindio.proyecto_final.model.builder;
import co.edu.uniquindio.proyecto_final.model.Producto;
import co.edu.uniquindio.proyecto_final.model.Vendedor;

import java.util.LinkedList;

public class VendedorBuilder {
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String usuario;
    private String contrasena;
    private LinkedList<Producto> listProducto;

    public VendedorBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public VendedorBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }
    public VendedorBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }
    public VendedorBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }
    public VendedorBuilder usuario(String usuario) {
        this.usuario = usuario;
        return this;
    }
    public VendedorBuilder contrasena(String contrasena){
        this.contrasena = contrasena;
        return this;
    }
    public VendedorBuilder listProducto(LinkedList<Producto> listProducto) {
        this.listProducto = listProducto;
        return this;
    }
    public Vendedor build() {return new Vendedor(
            nombre,
            apellido,
            cedula,
            direccion,
            usuario,
            contrasena,
            listProducto);}
}
