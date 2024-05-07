package co.edu.uniquindio.poo.proyecto_final.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private String name;
    private String description;
    private LocalDateTime date;
    private String image;
    private Location location;
    private Type type;

}
