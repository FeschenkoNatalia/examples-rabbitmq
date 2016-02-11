package ru.finnetrolle.examples.rabbitmq.restful;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.finnetrolle.examples.rabbitmq.model.ResponseDto;
import ru.finnetrolle.examples.rabbitmq.model.UserDto;

/**
 * Created by finnetrolle on 11.02.2016.
 */

@RequestMapping("digest")
@Component
public class Resource {

    @Autowired
    AmqpTemplate template;

    @Value("${rabbit.queue.test}")
    private String queueName;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    ResponseDto digest(@RequestBody UserDto user) {
        ResponseDto dto = (ResponseDto) template.convertSendAndReceive(queueName, user);
        return dto;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    UserDto digest() {
        return new UserDto();
    }

}
