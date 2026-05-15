package ProjectPhelipe.AplicacaoRabbitMQ.Rabbit;

import ProjectPhelipe.AplicacaoRabbitMQ.entity.EntityMessage;
import ProjectPhelipe.AplicacaoRabbitMQ.model.MessageRequest;
import ProjectPhelipe.AplicacaoRabbitMQ.repository.RepositoryMessage;
import ProjectPhelipe.AplicacaoRabbitMQ.service.EnviarEmail;
import ProjectPhelipe.AplicacaoRabbitMQ.service.SalvarDB;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PedidoConsumer {

    private final EnviarEmail email;
    private final SalvarDB salvarDB;

    public PedidoConsumer(EnviarEmail email, SalvarDB salvarDB) {
        this.email = email;
        this.salvarDB = salvarDB;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receberPedido(MessageRequest mensagem) {
        salvarDB.salvarDados(mensagem);
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_2)
    public void enviarEmail(MessageRequest mensagem) {
        email.enviarEmail(mensagem);
    }
}
