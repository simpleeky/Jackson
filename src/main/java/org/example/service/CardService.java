package org.example.service;

import lombok.Getter;
import org.example.model.Card;
import org.example.model.User;
import org.example.model.Users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CardService {
    private static final String PATH = "/Users/davronmahmarajabov/Desktop/demo/Jackson/cards.xml";
    @Getter
    private static List<Card> cards = new ArrayList<>();
    public XmlService<Card> xmlService;

    public CardService() {
        xmlService = new XmlService<>();
        try {
            cards = xmlService.readXml(PATH, Card.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Users addCard(Users usersWithCard) throws IOException {
        cards.addAll(usersWithCard.getCards());
        xmlService.writeXml(PATH, cards);
        return usersWithCard;
    }

    public List<Card> getCards() {
        return cards;
    }
}
