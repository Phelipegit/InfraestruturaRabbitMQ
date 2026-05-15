package ProjectPhelipe.AplicacaoRabbitMQ.Rabbit;

import ProjectPhelipe.AplicacaoRabbitMQ.model.MessageRequest;
import ProjectPhelipe.AplicacaoRabbitMQ.repository.RepositoryMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PedidoConsumer {

    private final RepositoryMessage repositoryMessage;

    public PedidoConsumer(RepositoryMessage repositoryMessage) {
        this.repositoryMessage = repositoryMessage;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receberPedido(MessageRequest mensagem) {
    }
}
