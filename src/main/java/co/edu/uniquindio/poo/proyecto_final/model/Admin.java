package co.edu.uniquindio.poo.proyecto_final.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends Person{
    private Admin instance;
    private Collection<Event> listEvent;

    private Admin(String email, String passwaord) {
        super();
    }

    /**
     * Cersiora que exista una única instancia de la clase Admin
     * @return una instancia de Admin
     */
    private Admin createAdmin(){
        if(instance == null){
            instance = new Admin("d", "d");
        }
        return instance;
    }
}
