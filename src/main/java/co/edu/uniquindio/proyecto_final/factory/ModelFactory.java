package co.edu.uniquindio.proyecto_final.factory;

import co.edu.uniquindio.proyecto_final.mapping.dto.PublicacionDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.mappers.MarketPlaceMappingImpl;
import co.edu.uniquindio.proyecto_final.model.*;
import co.edu.uniquindio.proyecto_final.service.IModelFactoryServices;

import java.util.ArrayList;
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

        Vendedor vendedor1 = Vendedor.builder()
                .nombre("Sebastian")
                .apellido("Quintero")
                .cedula("1005089187")
                .direccion("Mi casa")
                .usuario("Chupamatracas5000")
                .contrasena("1234")
                .build();

        Vendedor vendedor2 = Vendedor.builder()
                .nombre("Juanjojito")
                .apellido("Pachito")
                .cedula("0001")
                .direccion("La casa de el")
                .usuario("Pls_dont_commit")
                .contrasena("1234")
                .build();

        Vendedor vendedor3 = Vendedor.builder()
                .nombre("Daniel")
                .apellido("Garcia")
                .cedula("0002")
                .direccion("Daniel's house")
                .usuario("GucciMadrasso")
                .contrasena("1234")
                .build();

        Producto producto1 = Producto.builder()
                .nombre("Carro")
                .imagen("/co/edu/uniquindio/images/carro.jpg")
                .categoria("Vehiculo")
                .precio("10000")
                .estado(Estado.PUBLICADO)
                .build();

        Producto producto2 = Producto.builder()
                .nombre("Pollo")
                .imagen("/co/edu/uniquindio/images/pollo.jpg")
                .categoria("Comida")
                .precio("50")
                .estado(Estado.PUBLICADO)
                .build();

        Producto producto3 = Producto.builder()
                .nombre("Bate")
                .imagen("/co/edu/uniquindio/images/bate.jpg")
                .categoria("Deporte")
                .precio("900")
                .estado(Estado.PUBLICADO)
                .build();

        vendedor0.getListProducto().add(producto1);
        vendedor0.getListProducto().add(producto2);
        vendedor0.getListProducto().add(producto3);
        vendedor0.agregarAmigo(vendedor1);
        vendedor0.agregarAmigo(vendedor2);
        marketPlace.getProductos().add(producto1);
        marketPlace.getProductos().add(producto2);
        marketPlace.getProductos().add(producto3);

        marketPlace.getVendedores().add(vendedor0);
        marketPlace.getVendedores().add(vendedor1);
        marketPlace.getVendedores().add(vendedor2);
        marketPlace.getVendedores().add(vendedor3);

        return marketPlace;
    }

    @Override
    public boolean verificarNombreExistente(ProductoDto productoDto) {
        return marketPlace.verificarNombreExistente(productoDto.nombre());
    }

    @Override
    public boolean actualizarProducto(ProductoDto productoDto, VendedorDto vendedorDto) {
        Producto newProducto = mapper.productoDtoToProducto(productoDto);
        return marketPlace.actualizarProducto(newProducto, vendedorDto);
    }

    @Override
    public boolean eliminarProducto(ProductoDto producto, VendedorDto vendedorDto) {
        Producto newProducto = mapper.productoDtoToProducto(producto);
        return marketPlace.eliminarProducto(newProducto,vendedorDto.cedula());
    }

    @Override
    public boolean crearProducto(ProductoDto productoDto, VendedorDto vendedorDto) {
        Producto newProducto = mapper.productoDtoToProducto(productoDto);
        return marketPlace.crearProducto(newProducto, vendedorDto);
    }

    @Override
    public String obtenerCedulaVendedor(UsuarioDto usuarioDto) {
        return marketPlace.obtenerCedulaVendedor(usuarioDto);
    }

    @Override
    public boolean verificarCedulaExistente(VendedorDto vendedor) {
        if(marketPlace.verificarCedulaVendedor(vendedor.cedula())){
            return true;
        }
        return false;
    }

    @Override
    public boolean verificarVendedorExistente(VendedorDto vendedor) {
        if(marketPlace.verificarUserVendedor(vendedor.usuario())){
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
    public VendedorDto getVendedor(String cedula) {
        return mapper.VendedorToVendedorDto(marketPlace.getVendedor(cedula));
    }

    @Override
    public List<ProductoDto> getListaProductosDto(String id) {
        return mapper.ProductosToProductosDto(marketPlace.getProductos(id));
    }

    @Override
    public List<VendedorDto> getListaVendedoresDto(String id) {
        return mapper.vendedoresToVendedoresDto(marketPlace.getVendedores(id));
    }

    @Override
    public List<PublicacionDto> getListaPublicacionesDto() {
        return mapper.publicacionesToPublicacionesDto(marketPlace.getPublicaciones());
    }

    @Override
    public void agregarPublicacion(PublicacionDto publicacionDto) {
        Publicacion newPublicacion = mapper.publicacionDtoToPublicacion(publicacionDto);
        marketPlace.agregarPublicación(newPublicacion);
    }

    @Override
    public List<VendedorDto> getListaVendedoresDtoTotal(VendedorDto vendedorDto) {
        List<VendedorDto> lista = mapper.vendedoresToVendedoresDto(marketPlace.getVendedores());
        for (VendedorDto vendedor : lista) {
            if(vendedorDto.cedula().equals(vendedor.cedula())){
                lista.remove(vendedor);
                break;
            }
        }
        return lista;
    }

    @Override
    public boolean verificarAmigo(VendedorDto vendedorDto, String cedula) {
        return marketPlace.verificarAmigo(vendedorDto.cedula(),cedula);
    }

    @Override
    public void agregarVendedor(VendedorDto vendedorDto, VendedorDto vendedorDtoAmigo) {
        marketPlace.agregarVendedor(vendedorDto.cedula(),vendedorDtoAmigo.cedula());
    }

    @Override
    public void eliminarVendedor(VendedorDto vendedorDto, VendedorDto vendedorDtoAmigo) {
        marketPlace.eliminarVendedor(vendedorDto.cedula(),vendedorDtoAmigo.cedula());
    }
}
