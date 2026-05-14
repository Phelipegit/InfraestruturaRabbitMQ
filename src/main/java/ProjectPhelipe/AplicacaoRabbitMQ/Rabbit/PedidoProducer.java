package ProjectPhelipe.AplicacaoRabbitMQ.Rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PedidoProducer {

    private final RabbitTemplate rabbitTemplate;

    public PedidoProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void enviarPedido(String mensagem) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE,mensagem);
    }
}
