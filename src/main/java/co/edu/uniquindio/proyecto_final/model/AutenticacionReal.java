package co.edu.uniquindio.proyecto_final.model;

import co.edu.uniquindio.proyecto_final.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyecto_final.service.IAutenticacion;

import java.util.List;

public class AutenticacionReal implements IAutenticacion {
    private List<Vendedor> vendedores;

    public AutenticacionReal(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    @Override
    public boolean iniciarSesion(UsuarioDto usuarioDto) {
        for(Vendedor vendedor : vendedores){
            if(vendedor.getUsuario().equals(usuarioDto.user()) && vendedor.getContrasena().equals(usuarioDto.pass())){
                return true;
            }
        }
        return false;
    }
}
