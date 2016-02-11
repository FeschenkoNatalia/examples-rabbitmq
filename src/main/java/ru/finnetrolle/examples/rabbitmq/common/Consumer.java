package ru.finnetrolle.examples.rabbitmq.common;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.finnetrolle.examples.rabbitmq.model.ResponseDto;
import ru.finnetrolle.examples.rabbitmq.model.UserDto;

/**
 * Created by finnetrolle on 09.02.2016.
 */

@Component
public class Consumer {

    @RabbitListener(queues = "${rabbit.queue.test}")
    public ResponseDto digest(UserDto user) {
        ResponseDto dto = new ResponseDto();
        dto.setUser(user);
        String digest = DigestUtils.sha256Hex(user.toString());
        dto.setMd5(digest);
        System.out.println("Listener worked with digest = " + digest);
        return dto;
    }

}
