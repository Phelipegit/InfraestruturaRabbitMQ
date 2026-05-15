package ProjectPhelipe.AplicacaoRabbitMQ.Rabbit;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE = "pedidos-queue";

    public static final String QUEUE_2 = "queue-2";


    @Bean
    public Queue queue1() {
        return new Queue(QUEUE,true);
    }

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE_2,true);
    }
}
