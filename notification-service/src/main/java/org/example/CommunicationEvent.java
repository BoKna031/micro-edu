package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunicationEvent {
    private String request;
    private String sender;
    private String method;
    private String receiver;
    private String responseStatus;

    @Override
    public String toString() {
        return String.format("sender: %s sent %s %s to the %s and get %s", sender, method, request, receiver, responseStatus) ;
    }
}
