package com.pblgllgs.email.consumer;

import com.pblgllgs.email.dto.EmailRecordDto;
import com.pblgllgs.email.entity.EmailModel;
import com.pblgllgs.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class EmailConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenerEmailQueue(@Payload EmailRecordDto emailRecordDto){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDto,emailModel);
        log.info(emailRecordDto.emailTo());
        emailService.sendEmail(emailModel);
    }
}
