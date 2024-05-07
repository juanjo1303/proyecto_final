package co.edu.uniquindio.poo.proyecto_final.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    private double subPrice;
    private double totalPrice;
    private Collection<Ticket> listTicket;
}
