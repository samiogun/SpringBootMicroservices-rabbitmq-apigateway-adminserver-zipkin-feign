package org.ersun.ticketservice.model;

import lombok.Getter;

@Getter
public enum PriorityType {
    URGENT("Acil"),
    HIGH("Yuksek Oncelikli"),
    LOW("Onemsiz");

    private String label;

    PriorityType(String label){
        this.label = label;
    }

}
