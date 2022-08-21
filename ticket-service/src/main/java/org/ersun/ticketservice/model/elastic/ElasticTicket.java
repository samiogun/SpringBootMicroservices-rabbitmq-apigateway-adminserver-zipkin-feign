package org.ersun.ticketservice.model.elastic;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Builder
@EqualsAndHashCode(of = "id")
@Document(indexName = "ticket")
@NoArgsConstructor
@AllArgsConstructor
public class ElasticTicket {

    @Id
//    @Field(name = "id",type = FieldType.Text)
    private String id;
//    @Field(name = "id",type = FieldType.Text)
    private String description;
//    @Field(name = "id",type = FieldType.Text)
    private String notes;
//    @Field(name = "id",type = FieldType.Text)
    private String assignee;
//    @Field(name = "id",type = FieldType.Date_Range)
    private Date ticketDate;
//    @Field(name = "id",type = FieldType.Text)
    private String priorityType;
//    @Field(name = "id",type = FieldType.Text)
    private String ticketStatus;

}
