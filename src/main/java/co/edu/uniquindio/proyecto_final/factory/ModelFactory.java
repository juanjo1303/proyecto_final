package co.edu.uniquindio.proyecto_final.factory;

import co.edu.uniquindio.proyecto_final.mapping.dto.UsuarioDto;
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
        Vendedor vendedor0 = Vendedor.builder()
                .nombre("Pepe")
                .apellido("Martin")
                .cedula("0000")
                .direccion("Armenia")
                .usuario("user")
                .contrasena("1234")
                .build();

        Producto producto1 = Producto.builder()
                .nombre("Carro")
                .imagen("/co/edu/uniquindio/images/carro.jpg")
                .categoria("Vehiculo")
                .precio("$10000")
                .estado(Estado.PUBLICADO)
                .build();

        Producto producto2 = Producto.builder()
                .nombre("Pollo")
                .imagen("/co/edu/uniquindio/images/pollo.jpg")
                .categoria("Comida")
                .precio("$50")
                .estado(Estado.PUBLICADO)
                .build();

        Producto producto3 = Producto.builder()
                .nombre("Bate")
                .imagen("/co/edu/uniquindio/images/bate.jpg")
                .categoria("Deporte")
                .precio("$900")
                .estado(Estado.PUBLICADO)
                .build();

        vendedor0.getListProducto().add(producto1);
        vendedor0.getListProducto().add(producto2);
        vendedor0.getListProducto().add(producto3);

        marketPlace.getVendedores().add(vendedor0);

        return marketPlace;
    }

    @Override
    public boolean verificarVendedorExistente(VendedorDto vendedor) {
        if(marketPlace.verificarUserVendedor(vendedor.usuario()) /*&& marketPlace.verificarCedulaVendedor(vendedor.cedula())*/){
            return true;
        }
        return false;
    }

    @Override
    public boolean verificarCredenciales(UsuarioDto usuarioDto) {
        return marketPlace.verificarCredenciales(usuarioDto);
    }

    @Override
    public boolean crearVendedor(VendedorDto vendedor) {
            Vendedor newVendedor = mapper.vendedorDtoToVendedor(vendedor);
            return marketPlace.crearVendedor(newVendedor);
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
