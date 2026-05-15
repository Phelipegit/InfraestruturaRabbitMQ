package ProjectPhelipe.AplicacaoRabbitMQ.service;

import ProjectPhelipe.AplicacaoRabbitMQ.model.MessageRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EnviarEmail {

    private final JavaMailSender javaMailSender;

    public EnviarEmail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviarEmail(MessageRequest messageRequest) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message,true);

            helper.setFrom("phelipegithub@gmail.com");
            helper.setTo(messageRequest.getEmail());
            helper.setSubject(messageRequest.getMessage());
            helper.setText("Seu pedido foi recebido!", true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
