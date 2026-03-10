package parqueadero.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vehiculo {

    @Id
    private String placa;

    private String tipo;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
