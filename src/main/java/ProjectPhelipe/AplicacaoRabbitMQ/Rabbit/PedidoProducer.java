package ProjectPhelipe.AplicacaoRabbitMQ.Rabbit;

import ProjectPhelipe.AplicacaoRabbitMQ.model.MessageRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PedidoProducer {

    private final RabbitTemplate rabbitTemplate;

    public PedidoProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void salvarDB(MessageRequest mensagem) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE,mensagem);
    }

    public void enviarEmail(MessageRequest mensagem) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_2,mensagem);
    }
}
