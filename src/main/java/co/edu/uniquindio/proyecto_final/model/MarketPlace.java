package co.edu.uniquindio.proyecto_final.model;

import co.edu.uniquindio.proyecto_final.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.service.ICrudProducto;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Setter
@Getter
public class MarketPlace implements ICrudProducto {
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

    public LinkedList<Vendedor> getVendedores(String id) {
        Vendedor v = getVendedor(id);
        return v.getListVendedores();
    }

    public boolean verificarUserVendedor(String usuario) {
        Vendedor vendedor = null;
        for(Vendedor vendedor1 : vendedores){
            if(vendedor1.getUsuario().equals(usuario)){
                vendedor = vendedor1;
                break;
            }
        }

        return vendedor == null;
    }

    public boolean verificarCedulaVendedor(String cedula) {
        Vendedor vendedor = null;
        for(Vendedor vendedor1 : vendedores){
            if(vendedor1.getCedula().equals(cedula)){
                vendedor = vendedor1;
                break;
            }
        }
        return vendedor == null;
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

    @Override
    public boolean crearProducto(Producto newProducto, VendedorDto vendedorDto) {
        productos.add(newProducto);
        for(Vendedor vendedor : vendedores){
            if (vendedor.getUsuario().equals(vendedorDto.usuario())){
                vendedor.agregarProducto(newProducto);
                break;
            }
        }
        System.out.println(productos);

        return true;
    }

    public boolean eliminarProducto(Producto producto, String cedula) {
        boolean eliminado = false;
        for(Producto producto1 : productos){
            if(producto1.getNombre().equals(producto.getNombre())){
                productos.remove(producto);
                break;
            }
        }

        for(Vendedor vendedor : vendedores){
            if(vendedor.getCedula().equals(cedula)){
                vendedor.eliminarProducto(producto);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }

    @Override
    public boolean actualizarProducto(Producto newProducto, VendedorDto vendedorDto) {
        boolean estado = false;
        for(Producto producto : productos){
            if(producto.getNombre().equals(newProducto.getNombre())){
                producto.setCategoria(newProducto.getCategoria());
                producto.setPrecio(newProducto.getPrecio());
                producto.setEstado(newProducto.getEstado());
                estado = true;
            }
        }
        for(Vendedor vendedor : vendedores){
            if(vendedor.getCedula().equals(vendedorDto.cedula())){
                estado = vendedor.actualizarProducto(newProducto);
            }
        }
        return estado;
    }

    @Override
    public Producto getProducto(String nombre) {
        Producto newProducto = null;
        for(Producto producto : productos){
            if(producto.getNombre().equals(nombre)){
               newProducto = producto;
            }
        }
        return newProducto;
    }

    public boolean verificarNombreExistente(String nombre) {
        boolean existe = false;
        for(Producto producto : productos){
            if (producto.getNombre().equals(nombre)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public boolean verificarAmigo(String cedula, String cedulaAmigo) {
        boolean existe = true;
        for(Vendedor vendedor : vendedores){
            if(vendedor.getCedula().equals(cedula)){
                existe = vendedor.verificarAmigo(cedulaAmigo);

            }
        }
        return existe;
    }

    public void agregarVendedor(String cedula, String cedulaAmigo) {
        for (Vendedor vendedor : vendedores){
            if(vendedor.getCedula().equals(cedula)){
                for (Vendedor vendedorAmigo : vendedores){
                    if(vendedorAmigo.getCedula().equals(cedulaAmigo)){
                        vendedor.agregarAmigo(vendedorAmigo);
                    }
                }
            }
        }
    }

    public void eliminarVendedor(String cedula, String cedulaAmigo) {
        for (Vendedor vendedor : vendedores){
            if(vendedor.getCedula().equals(cedula)){
                for (Vendedor vendedorAmigo : vendedores){
                    if(vendedorAmigo.getCedula().equals(cedulaAmigo)){
                        vendedor.eliminarAmigo(vendedorAmigo);
                    }
                }
            }
        }
    }

    public void agregarPublicacion(Publicacion newPublicacion) {
        publicaciones.add(newPublicacion);
        for(Vendedor vendedor : vendedores){
            if(vendedor.getCedula().equals(newPublicacion.getVendedor().getCedula())){
                vendedor.agregarPublicacion(newPublicacion);
            }
        }
    }
}

