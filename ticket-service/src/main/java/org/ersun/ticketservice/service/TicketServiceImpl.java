package org.ersun.ticketservice.service;

import lombok.RequiredArgsConstructor;
import org.ersun.feign.clients.AccountServiceClient;
import org.ersun.feign.model.account.AccountDto;
import org.ersun.feign.model.ticket.TicketDto;
import org.ersun.ticketservice.model.PriorityType;
import org.ersun.ticketservice.model.Ticket;
import org.ersun.ticketservice.model.TicketStatus;
import org.ersun.ticketservice.model.elastic.ElasticTicket;
import org.ersun.ticketservice.repository.elastic.TicketElasticRepository;
import org.ersun.ticketservice.repository.mysql.TicketRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketElasticRepository ticketElasticRepository;
    private final ModelMapper modelMapper;
    private final AccountServiceClient accountServiceClient;
    private final StreamBridge streamBridge;

    @Override
    @Transactional
    public TicketDto saveTicket(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
//        ticket.setAssignee();   Account API üzerinden doğrula.

        ResponseEntity<AccountDto> accountDtoResponseEntity = accountServiceClient.get(ticketDto.getAssignee());
        Assert.notNull(accountDtoResponseEntity.getBody());
        Assert.state(accountDtoResponseEntity.getStatusCode().equals(HttpStatus.OK));

        Assert.notNull(ticketDto.getDescription(), "Description");
        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket.setAssignee(accountDtoResponseEntity.getBody().getId());

        ticket = ticketRepository.save(ticket);

        ElasticTicket elasticTicket = ElasticTicket.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                .assignee(accountDtoResponseEntity.getBody().getId())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate())
                .build();

        ticketElasticRepository.save(elasticTicket);

        ticketDto.setId(ticket.getId());

        streamBridge.send("output",ticketDto);


        return ticketDto;
    }

    @Override
    public TicketDto updateTicket(String id, TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getTicketById(String id) {
        return null;
    }

    @Override
    public void deleteTicketById(String id) {

    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }
}
