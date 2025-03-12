package in.webartisan.springboot_rabbitmq.controller;

import in.webartisan.springboot_rabbitmq.dto.User;
import in.webartisan.springboot_rabbitmq.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")

public class JsonMessageController {
    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    public JsonMessageController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    @PostMapping("publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        return rabbitMQJsonProducer.sendJsonMessage(user);
    }
}
