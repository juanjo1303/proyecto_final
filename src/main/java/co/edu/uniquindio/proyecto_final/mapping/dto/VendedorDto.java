package co.edu.uniquindio.proyecto_final.mapping.dto;

public record VendedorDto(String nombre, String apellido, String cedula, String direccion, String usuario, String contrasena) {
    public String getCedula() {
        return cedula;
    }
}
