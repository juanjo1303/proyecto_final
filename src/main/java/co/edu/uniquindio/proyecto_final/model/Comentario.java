package co.edu.uniquindio.proyecto_final.model;

public class Comentario {
    private String texto;
    private Vendedor vendedor;

    public Comentario(String texto, Vendedor vendedor) {
        this.texto = texto;
        this.vendedor = vendedor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
