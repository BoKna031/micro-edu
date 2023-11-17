package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class UserCredential {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
}
