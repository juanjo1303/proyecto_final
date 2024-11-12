package co.edu.uniquindio.proyecto_final.factory;

import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.mappers.MarketPlaceMappingImpl;
import co.edu.uniquindio.proyecto_final.model.Estado;
import co.edu.uniquindio.proyecto_final.model.MarketPlace;
import co.edu.uniquindio.proyecto_final.model.Producto;
import co.edu.uniquindio.proyecto_final.model.Vendedor;
import co.edu.uniquindio.proyecto_final.service.IModelFactoryServices;

import java.util.List;

public class ModelFactory implements IModelFactoryServices {
    private static ModelFactory instance;
    MarketPlace marketPlace;
    MarketPlaceMappingImpl mapper;

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    private ModelFactory() {
        mapper = new MarketPlaceMappingImpl();
        marketPlace = inicializarDatos();
    }

    private static MarketPlace inicializarDatos() {
        MarketPlace marketPlace = new MarketPlace("abc");
        Vendedor vendedor9 = new Vendedor();
        vendedor9.setNombre("Pepe");
        vendedor9.setApellido("Martin");
        vendedor9.setCedula("0000");
        vendedor9.setDireccion("alli");
        vendedor9.setUsuario("user");
        vendedor9.setContrasena("1234");

        Producto producto1 = new Producto("Carro", "/co/edu/uniquindio/images/carro.jpg", "Cualquier cosa", "100000000000 Dolar", Estado.PUBLICADO);
        Producto producto2 = new Producto("Pollo", "/co/edu/uniquindio/images/pollo.jpg", "Comida", "500000 dolar", Estado.PUBLICADO);
        Producto producto3 = new Producto("Bate", "/co/edu/uniquindio/images/bate.jpg", "Deporte", "9000000000 bolivares", Estado.PUBLICADO);
        vendedor9.getListProducto().add(producto1);
        vendedor9.getListProducto().add(producto2);
        vendedor9.getListProducto().add(producto3);

        marketPlace.getVendedores().add(vendedor9);
        return marketPlace;
    }

    @Override
    public VendedorDto getVendedor(String id) {
        return mapper.VendedorToVendedorDto(marketPlace.getVendedor(id));
    }

    @Override
    public List<ProductoDto> getListaProductosDto(String id) {
        return mapper.ProductosToProductosDto(marketPlace.getProductos(id));
    }
}
