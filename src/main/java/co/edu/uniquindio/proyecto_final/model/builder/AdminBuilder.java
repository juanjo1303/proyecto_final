package co.edu.uniquindio.proyecto_final.model.builder;

import co.edu.uniquindio.proyecto_final.model.Admin;
import co.edu.uniquindio.proyecto_final.model.Usuario;

public class AdminBuilder extends UsuarioBuilder<AdminBuilder> {
    @Override
    public Usuario build() {
        return new Admin(user, pass);
    }

    @Override
    protected AdminBuilder self() {
        return this;
    }
}
