package co.edu.uniquindio.proyecto_final.factory;

import co.edu.uniquindio.proyecto_final.mapping.mappers.MarketPlaceMappingImpl;
import co.edu.uniquindio.proyecto_final.model.MarketPlace;

public class ModelFactory {
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
        return marketPlace;
    }

}
