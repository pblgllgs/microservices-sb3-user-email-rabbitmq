package com.pblgllgs.user.producer;

import com.pblgllgs.user.dto.EmailDto;
import com.pblgllgs.user.entity.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publisherMessageEmail(UserModel userModel){
        var emailDto = EmailDto.builder()
                .userId(userModel.getUserId())
                .emailTo(userModel.getEmail())
                .subject("Registro exitoso!!")
                .text("Bienvenido usuario "+ userModel.getEmail())
                .build();
        rabbitTemplate.convertAndSend("",routingKey,emailDto);
    }
}
