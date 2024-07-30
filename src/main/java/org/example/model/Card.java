package org.example.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class Card {
    @JacksonXmlProperty(isAttribute = true)
    private UUID id;
    private UUID userId;
    @JacksonXmlProperty(localName = "card_name")
    private String cardName;
    @JacksonXmlProperty(localName = "card_number")
    private String cardNumber;
    private String expiryDate;
    @JacksonXmlProperty(localName = "card_password")
    private String password;
    @JacksonXmlProperty(localName = "card_balance")
    private double balance;

    public Card() {
        this.id = UUID.randomUUID();
        this.userId = UUID.randomUUID();
    }

    public Card(String cardName, String cardNumber, String expiryDate, String password, double balance) {
        this();
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.password = password;
        this.balance = balance;
    }
}
