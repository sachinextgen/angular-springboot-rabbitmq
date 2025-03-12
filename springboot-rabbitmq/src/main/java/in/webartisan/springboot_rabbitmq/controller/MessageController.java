package in.webartisan.springboot_rabbitmq.controller;

import in.webartisan.springboot_rabbitmq.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class MessageController {
    private final RabbitMQProducer producer;

    public MessageController(RabbitMQProducer rabbitMQProducer) {
        this.producer = rabbitMQProducer;
    }

    @GetMapping("publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        return this.producer.sendMessage(message);
    }
}
