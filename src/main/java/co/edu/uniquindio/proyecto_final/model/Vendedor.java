package co.edu.uniquindio.proyecto_final.model;

import java.util.LinkedList;

public class Vendedor extends Usuario{
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private LinkedList<Vendedor> vendedores =  new LinkedList<Vendedor>();
    private LinkedList<Producto> productos = new LinkedList<Producto>();
    private Muro muroAsociado;

    public Vendedor() {
        super();
    }

    public Vendedor(String nombre, String apellido, String cedula, String direccion, Muro muroAsociado, String user, String pass) {
        super(user, pass);
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.muroAsociado = muroAsociado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Muro getMuro() {
        return muroAsociado;
    }

    public void setMuro(Muro muroAsociado) {
        this.muroAsociado = muroAsociado;
    }
}
