package ProjectPhelipe.AplicacaoRabbitMQ.service;

import ProjectPhelipe.AplicacaoRabbitMQ.Rabbit.PedidoProducer;
import ProjectPhelipe.AplicacaoRabbitMQ.entity.EntityMessage;
import ProjectPhelipe.AplicacaoRabbitMQ.model.MessageRequest;
import ProjectPhelipe.AplicacaoRabbitMQ.repository.RepositoryMessage;
import org.springframework.stereotype.Service;

@Service
public class SalvarDB {

    private final RepositoryMessage repositoryMessage;
    private final PedidoProducer pedidoProducer;

    public SalvarDB(RepositoryMessage repositoryMessage, PedidoProducer pedidoProducer) {
        this.repositoryMessage = repositoryMessage;
        this.pedidoProducer = pedidoProducer;
    }

    public void salvarDados(MessageRequest messageRequest) {
        EntityMessage entityMessage = new EntityMessage(messageRequest.getEmail(), messageRequest.getMessage());

        repositoryMessage.save(entityMessage);

        pedidoProducer.enviarEmail(messageRequest);
    }
}
