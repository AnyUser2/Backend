package parqueadero.model;

import jakarta.persistence.*;

@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String placa;

    public Vehiculo() {}

    public Long getId() { return id; }

    public String getPlaca() { return placa; }

    public void setPlaca(String placa) { this.placa = placa; }
}