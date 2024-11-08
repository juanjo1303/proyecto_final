package co.edu.uniquindio.proyecto_final.model;
import co.edu.uniquindio.proyecto_final.model.builder.VendedorBuilder;
import lombok.Data;
import lombok.AllArgsConstructor;
import java.util.LinkedList;
@Data
@AllArgsConstructor

public class Vendedor {
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String usuario;
    private String contrasena;
    private LinkedList<Producto> listProducto;
    private LinkedList<Vendedor> listVendedores;

    public static VendedorBuilder builder() {return new VendedorBuilder();}
}