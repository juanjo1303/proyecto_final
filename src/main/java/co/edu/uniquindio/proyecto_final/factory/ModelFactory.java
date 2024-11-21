package co.edu.uniquindio.proyecto_final.factory;

import co.edu.uniquindio.proyecto_final.mapping.dto.PublicacionDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.mappers.MarketPlaceMappingImpl;
import co.edu.uniquindio.proyecto_final.model.*;
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
                .usuario("Juan")
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

        Vendedor vendedor4 = Vendedor.builder()
                .nombre("Jhan Carlos")
                .apellido("Martinez")
                .usuario("AbuelitasDestroyer")
                .cedula("123456789")
                .direccion("La casa de su madre")
                .contrasena("1234")
                .build();

        Vendedor vendedor5 = Vendedor.builder()
                .nombre("Perlita")
                .apellido("Juarez")
                .cedula("0003")
                .direccion("Una casa cualquiera")
                .usuario("PerlitaLinda")
                .contrasena("1234")
                .build();

        Producto producto4 = Producto.builder()
                .nombre("Mi casita")
                .categoria("Hogar")
                .estado(Estado.PUBLICADO)
                .precio("1")
                .imagen("/co/edu/uniquindio/images/casitaJhan.jpg")
                .build();

        Producto producto5 = Producto.builder()
                .nombre("Mi pc")
                .categoria("Tecnología")
                .estado(Estado.PUBLICADO)
                .precio("1")
                .imagen("/co/edu/uniquindio/images/computadorJhan.jpg")
                .build();

        Producto producto6 = Producto.builder()
                .nombre("Mi carrito")
                .categoria("Vehículo")
                .estado(Estado.PUBLICADO)
                .precio("1")
                .imagen("/co/edu/uniquindio/images/carroJhan.jpg")
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

        Producto producto7 = Producto.builder()
                .nombre("Celular")
                .categoria("Tecnologia")
                .precio("666")
                .estado(Estado.PUBLICADO)
                .imagen("/co/edu/uniquindio/images/ceñuco.jpg")
                .build();

        Publicacion publicacion = Publicacion.builder()
                .vendedor(vendedor4)
                .producto(producto4)
                .descripcion("Vendo mi casita pa poder comer")
                .build();

        vendedor0.agregarProducto(producto1);
        vendedor0.agregarProducto(producto2);
        vendedor0.agregarProducto(producto3);
        vendedor4.agregarProducto(producto4);
        vendedor4.agregarProducto(producto5);
        vendedor4.agregarProducto(producto6);
        vendedor5.agregarProducto(producto7);

        vendedor0.agregarAmigo(vendedor1);
        vendedor0.agregarAmigo(vendedor2);
        vendedor0.agregarAmigo(vendedor5);

        marketPlace.getProductos().add(producto1);
        marketPlace.getProductos().add(producto2);
        marketPlace.getProductos().add(producto3);
        marketPlace.getProductos().add(producto4);
        marketPlace.getProductos().add(producto5);
        marketPlace.getProductos().add(producto6);
        marketPlace.getProductos().add(producto7);

        marketPlace.getVendedores().add(vendedor0);
        marketPlace.getVendedores().add(vendedor1);
        marketPlace.getVendedores().add(vendedor2);
        marketPlace.getVendedores().add(vendedor3);
        marketPlace.getVendedores().add(vendedor4);
        marketPlace.getVendedores().add(vendedor5);

        marketPlace.agregarPublicacion(publicacion);

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
        return marketPlace.verificarCedulaVendedor(vendedor.cedula());
    }

    @Override
    public boolean verificarVendedorExistente(VendedorDto vendedor) {
        return marketPlace.verificarUserVendedor(vendedor.usuario());
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
        marketPlace.agregarPublicacion(newPublicacion);
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
