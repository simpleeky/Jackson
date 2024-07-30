package org.example.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
public class User {
    @JacksonXmlProperty(isAttribute = true)
    private UUID id;
    @JacksonXmlProperty(localName = "first_name")
    private String firstName;
    @JacksonXmlProperty(localName = "last_name")
    private String lastName;
    private String username;
    private int age;
    private String password;

    public User() {
        this.id = UUID.randomUUID();
    }

    public User(String firstName, String lastName, String username, int age, String password) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.age = age;
        this.password = password;
    }
}
