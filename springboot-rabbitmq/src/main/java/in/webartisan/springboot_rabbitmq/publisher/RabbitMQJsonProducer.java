package in.webartisan.springboot_rabbitmq.publisher;

import in.webartisan.springboot_rabbitmq.dto.User;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {
    private final Logger logger = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.json.routingKey.name}")
    private String jsonRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public ResponseEntity<String> sendJsonMessage(User user){

        logger.info(String.format("message sent -> %s",user));
        System.out.println(user);
        try {
            rabbitTemplate.convertAndSend(exchange,jsonRoutingKey,user);
            return ResponseEntity.ok("Message sent to RabbitMQ: " + user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send message.");
        }
    }
}
