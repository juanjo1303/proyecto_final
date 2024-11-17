package co.edu.uniquindio.proyecto_final.model;
import co.edu.uniquindio.proyecto_final.model.builder.ProductoBuilder;
import lombok.Data;
import lombok.AllArgsConstructor;
@Data
@AllArgsConstructor

public class Producto {
    public String nombre;
    public String imagen;
    public String categoria;
    public String precio;
    public Estado estado;

    public static ProductoBuilder builder() {return new ProductoBuilder();}
}
