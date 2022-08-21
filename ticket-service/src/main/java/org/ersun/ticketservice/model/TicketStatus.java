package org.ersun.ticketservice.model;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Acik"),
    IN_PROGRESS("Uzerinde Calisiliyor"),
    RESOLVED("Cozuldu"),
    CLOSED("Kapali");

    private String label;

    TicketStatus(String label){
        this.label = label;
    }

}
