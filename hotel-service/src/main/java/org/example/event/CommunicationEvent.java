package org.example.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunicationEvent {
    private String request;
    private String method;
    private String sender;
    private String receiver;
    private String responseStatus;

}
