package co.edu.uniquindio.proyecto_final.model;
import co.edu.uniquindio.proyecto_final.model.builder.VendedorBuilder;
import java.util.LinkedList;

public class Vendedor {
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String usuario;
    private String contrasena;
    private LinkedList<Producto> listProducto;
    private LinkedList<Vendedor> listVendedores;
    private LinkedList<Publicacion> listPublicaciones;

    public Vendedor() {
        listProducto = new LinkedList<>();
        listVendedores = new LinkedList<>();
        listPublicaciones = new LinkedList<>();
    }

    public Vendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.usuario = usuario;
        this.direccion = direccion;
        this.contrasena = contrasena;
        listProducto = new LinkedList<>();
        listVendedores = new LinkedList<>();
        listPublicaciones = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public LinkedList<Publicacion> getListPublicaciones() {
        return listPublicaciones;
    }

    public void setListPublicaciones(LinkedList<Publicacion> listPublicaciones) {
        this.listPublicaciones = listPublicaciones;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LinkedList<Producto> getListProducto() {
        return listProducto;
    }

    public void setListProducto(LinkedList<Producto> listProducto) {
        this.listProducto = listProducto;
    }

    public LinkedList<Vendedor> getListVendedores() {
        return listVendedores;
    }

    public void setListVendedores(LinkedList<Vendedor> listVendedores) {
        this.listVendedores = listVendedores;
    }

    public static VendedorBuilder builder() {return new VendedorBuilder();}

    public void agregarProducto(Producto newProducto) {
        listProducto.add(newProducto);
    }

    public void eliminarProducto(Producto producto) {
        listProducto.remove(producto);
    }

    public boolean actualizarProducto(Producto newProducto) {
        boolean estado = false;
        for(Producto producto: listProducto){
            if(producto.getNombre().equals(newProducto.getNombre())){
                producto.setCategoria(newProducto.getCategoria());
                producto.setPrecio(newProducto.getPrecio());
                producto.setEstado(newProducto.getEstado());
                estado = true;

            }
        }
        return estado;
    }

    public boolean verificarAmigo(String cedula) {
        boolean estado = true;
        for(Vendedor vendedor: listVendedores){
            if(vendedor.getCedula().equals(cedula)){
                estado = false;
            }
        }
        return estado;
    }

    public void agregarAmigo(Vendedor vendedorAmigo) {
        listVendedores.add(vendedorAmigo);
    }

    public void eliminarAmigo(Vendedor vendedorAmigo) {
        listVendedores.remove(vendedorAmigo);
    }

    public void agregarPublicacion(Publicacion newPublicacion) {
        listPublicaciones.add(newPublicacion);
    }
}