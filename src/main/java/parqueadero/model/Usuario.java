package parqueadero.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Setter;
import jakarta.persistence.Id;

@Entity
@Table(name = "users")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    private String role; // ADMIN, USER

    private boolean active;

    public void setActive(boolean active) {
        this.active = active;
    }

}
