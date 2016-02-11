package ru.finnetrolle.examples.rabbitmq.restful;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
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

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {}

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    ResponseDto digest(@RequestBody UserDto user) {
        ResponseDto dto = (ResponseDto)
                template.convertSendAndReceive(queueName, user);
        if (dto == null) {
            throw new ResourceNotFoundException();
        }
        return dto;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    UserDto digest() {
        return new UserDto();
    }

}
