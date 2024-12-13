package org.example.devoir2022.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Incident {
    private String memberId;
    private String reference;
    private String Date;
    private String status;
    //Copy constructer
    Incident(Incident incident){
        this.memberId = incident.getMemberId();
        this.reference = incident.getReference();
        this.Date = incident.getDate();
        this.status = incident.getStatus();
    }
}
