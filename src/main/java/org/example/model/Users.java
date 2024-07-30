package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
    @JacksonXmlElementWrapper(localName = "users", useWrapping = false)
    @JacksonXmlProperty(localName = "user")
    private List<User> users;

    @JacksonXmlElementWrapper(localName = "cards", useWrapping = false)
    @JacksonXmlProperty(localName = "card")
    private List<Card> cards;
}
