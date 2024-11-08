package co.edu.uniquindio.proyecto_final.model.builder;

import co.edu.uniquindio.proyecto_final.model.Usuario;

public abstract class UsuarioBuilder<T extends UsuarioBuilder<T>> {
    protected String user;
    protected String pass;

    public T user(String user) {
        this.user = user;
        return self();
    }

    public T pass(String pass) {
        this.pass = pass;
        return self();
    }

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

    public abstract Usuario build();
}
