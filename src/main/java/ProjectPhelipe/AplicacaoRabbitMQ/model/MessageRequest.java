package ProjectPhelipe.AplicacaoRabbitMQ.model;

import lombok.Getter;

@Getter
public class MessageRequest {

    private String email;

    private String message;

    public MessageRequest(String email,String message) {
        this.email = email;
        this.message = message;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMessage() {
        return this.message;
    }
}
