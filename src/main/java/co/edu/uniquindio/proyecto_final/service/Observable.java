package co.edu.uniquindio.proyecto_final.service;

import java.io.IOException;

public interface Observable {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers() throws IOException;
}
