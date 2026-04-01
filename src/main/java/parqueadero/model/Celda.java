package parqueadero.model;

import jakarta.persistence.*;

@Entity
public class Celda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numero;

    private boolean disponible = true;

    public Celda() {}

    public Long getId() { return id; }

    public String getNumero() { return numero; }

    public void setNumero(String numero) { this.numero = numero; }

    public boolean isDisponible() { return disponible; }

    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}