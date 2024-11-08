package co.edu.uniquindio.proyecto_final.service;
import co.edu.uniquindio.proyecto_final.model.Vendedor;
import co.edu.uniquindio.proyecto_final.model.builder.VendedorBuilder;
import java.util.LinkedList;

public interface ICrudVendedor {
    boolean crearVendedor(Vendedor newVendedor);
    boolean eliminarVendedor(String cedula);
    boolean actualizarProducto(String cedula, VendedorBuilder vendedorBuilder);
    Vendedor getVendedorCrud(String cedula);
    LinkedList<Vendedor> getListVendedorsCrud();
}