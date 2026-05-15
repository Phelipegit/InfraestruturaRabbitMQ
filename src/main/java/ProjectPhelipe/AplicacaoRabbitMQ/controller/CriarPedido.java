package ProjectPhelipe.AplicacaoRabbitMQ.controller;

import ProjectPhelipe.AplicacaoRabbitMQ.Rabbit.PedidoProducer;
import ProjectPhelipe.AplicacaoRabbitMQ.model.MessageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CriarPedido {

    private final PedidoProducer pedidoProducer;

    public CriarPedido(PedidoProducer pedidoProducer) {
        this.pedidoProducer = pedidoProducer;
    }

    @PostMapping("/enviar")
    public String enviar(@RequestBody MessageRequest mensagem) {
        pedidoProducer.salvarDB(mensagem);
        return "Pedido enviado";
    }
}
