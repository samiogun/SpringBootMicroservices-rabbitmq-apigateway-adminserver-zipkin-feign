package org.ersun.ticketservice.repository.elastic;

import org.ersun.ticketservice.model.elastic.ElasticTicket;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketElasticRepository extends ElasticsearchRepository<ElasticTicket, String> {
}
