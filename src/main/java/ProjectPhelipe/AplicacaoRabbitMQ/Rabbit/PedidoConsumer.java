package ProjectPhelipe.AplicacaoRabbitMQ.Rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PedidoConsumer {

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receberPedido(String mensagem) {
        System.out.println("Pedido recebido " + mensagem);
    }
}
