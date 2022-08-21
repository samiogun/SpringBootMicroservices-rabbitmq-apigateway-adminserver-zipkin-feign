package org.ersun.notification.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ersun.feign.clients.AccountServiceClient;
import org.ersun.feign.model.ticket.TicketDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class NotificationListener {

    private final AccountServiceClient accountServiceClient;

    @Bean
    public Consumer<TicketDto> sendNotification(){
        return ticketDto -> log.info("Sending mail to {}",accountServiceClient.get(ticketDto.getAssignee()).getBody().getEmail());
    }

}
