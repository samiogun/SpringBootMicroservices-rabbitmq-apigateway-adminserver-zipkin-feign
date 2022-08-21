package org.ersun.ticketservice.service;

import org.ersun.feign.model.ticket.TicketDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {

    TicketDto saveTicket(TicketDto ticketDto);

    TicketDto updateTicket(String id, TicketDto ticketDto);

    TicketDto getTicketById(String id);

    void deleteTicketById(String id);

    Page<TicketDto> getPagination(Pageable pageable);


}
