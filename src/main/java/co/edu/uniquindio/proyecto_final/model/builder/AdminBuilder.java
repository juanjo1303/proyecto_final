package co.edu.uniquindio.proyecto_final.model.builder;

import co.edu.uniquindio.proyecto_final.model.Admin;

public class AdminBuilder extends UsuarioBuilder<AdminBuilder> {
    @Override
    public Admin build() {
        return new Admin(user, pass);
    }

    @Override
    protected AdminBuilder self() {
        return this;
    }
}
