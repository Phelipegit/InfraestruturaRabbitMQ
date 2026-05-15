package ProjectPhelipe.AplicacaoRabbitMQ.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
public class EntityMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Email
    private String email;

    private String message;

    private LocalDate localDate;

    public EntityMessage(String email,String message) {
        this.email = email;
        this.message = message;
        this.localDate = LocalDate.now();
    }

    public EntityMessage() {

    }
}
