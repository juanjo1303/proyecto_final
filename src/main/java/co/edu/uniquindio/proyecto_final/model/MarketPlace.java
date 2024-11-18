package co.edu.uniquindio.proyecto_final.model;

import co.edu.uniquindio.proyecto_final.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;

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

    public Vendedor getVendedor(String cedula) {
        for (Vendedor v : vendedores) {
            if (v.getCedula().equals(cedula)) {
                return v;
            }
        }
        return null;
    }
    public LinkedList<Producto> getProductos(String id) {
        Vendedor v = getVendedor(id);
                return v.getListProducto();
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
    public boolean verificarUserVendedor(String usuario) {
        Vendedor vendedor = null;
        for(Vendedor vendedor1 : vendedores){
            if(vendedor1.getUsuario().equals(usuario)){
                vendedor = vendedor1;
                break;
            }
        }

            if(vendedor == null){
                return true;
            }
            return false;
        }

    public boolean verificarCedulaVendedor(String cedula) {
        Vendedor vendedor = null;
        for(Vendedor vendedor1 : vendedores){
            if(vendedor1.getCedula().equals(cedula)){
                vendedor = vendedor1;
                break;
            }
        }
        if(vendedor == null){
            return true;
        }
        return false;
    }

    public boolean crearVendedor(Vendedor newVendedor) {
        vendedores.add(newVendedor);
        return true;
    }

    public boolean verificarCredenciales(UsuarioDto usuarioDto) {
        for(Vendedor vendedor : vendedores){
            if(vendedor.getUsuario().equals(usuarioDto.user()) && vendedor.getContrasena().equals(usuarioDto.pass())){
                return true;
            }
        }
        return false;
    }

    public String obtenerCedulaVendedor(UsuarioDto usuarioDto) {
        String cedula = null;
        for(Vendedor vendedor : vendedores){
            if(vendedor.getUsuario().equals(usuarioDto.user())){
                cedula = vendedor.getCedula();
            }
        }
        return cedula;
    }

    public boolean crearProducto(Producto newProducto, VendedorDto vendedorDto) {
        productos.add(newProducto);
        for(Vendedor vendedor : vendedores){
            if (vendedor.getUsuario().equals(vendedorDto.usuario())){
                vendedor.agregarProducto(newProducto);
                break;
            }
        }
        return true;
    }
}

