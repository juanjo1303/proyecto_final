package co.edu.uniquindio.proyecto_final.service;
import co.edu.uniquindio.proyecto_final.model.Producto;
import co.edu.uniquindio.proyecto_final.model.builder.ProductoBuilder;
import java.util.LinkedList;

public interface ICrudProducto {
    boolean crearProducto(String nombre, ProductoBuilder productoBuilder);
    boolean eliminarProducto(String nombre);
    boolean actualizarProducto(String nombre, ProductoBuilder productoBuilder);
    Producto getProductoCrud(String nombre);
    LinkedList<Producto> getListProductoCrud();
}
