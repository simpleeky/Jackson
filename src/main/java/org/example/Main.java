package org.example;

import org.example.model.Card;
import org.example.model.User;
import org.example.model.Users;
import org.example.service.CardService;
import org.example.service.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerString = new Scanner(System.in);
    static UserService userService = new UserService();
    static CardService cardService = new CardService();

    public static void main(String[] args) throws IOException {
        int enter = 1;
        while (enter != 0) {
            System.out.println("1. Add user. 2. Login.  3. List users. 0. Exit");
            enter = scannerInt.nextInt();
            switch (enter) {
                case 1 -> {
                    addUser();
                }
                case 2 -> {
                    login();
                }
                case 3 -> {
                    listUsers();
                }
            }
        }
    }

    public static void addUser() throws IOException {
        System.out.print("Enter first name: ");
        String firstName = scannerString.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scannerString.nextLine();

        System.out.print("Enter username: ");
        String username = scannerString.nextLine();

        System.out.print("Enter age: ");
        int age = scannerInt.nextInt();

        System.out.print("Enter password: ");
        String password = scannerString.nextLine();

        User user = new User(firstName, lastName, username, age, password);
        Users users = new Users();
        users.setUsers(List.of(user));

        if (userService.addUser(users) != null) {
            System.out.println("User added successfully.");
        } else {
            System.out.println("User already exists.");
        }
    }

    public static void login() throws IOException {
        System.out.print("Enter username: ");
        String username = scannerString.nextLine();

        System.out.print("Enter password: ");
        String password = scannerString.nextLine();

        User login = userService.login(username, password);
        if (login != null) {
            int stepCardService = 10;
            while (stepCardService != 0) {
                System.out.println("1. Add Card. 2. List cards. 0. Exit");
                stepCardService = scannerInt.nextInt();
                switch (stepCardService) {
                    case 1 -> {
                        addCard();
                    }
                    case 2 -> {
                        for (Card card : cardService.getCards()) {
                            if (card.getUserId().equals(login.getId())) {
                                System.out.println(card);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void listUsers() {
        List<User> userList = UserService.getUsers();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    public static void addCard() throws IOException {
        System.out.print("Enter card name: ");
        String cardName = scannerString.nextLine();

        System.out.print("Enter card number: ");
        String cardNumber = scannerString.nextLine();

        System.out.print("Enter expiry date: ");
        String expiryDate = scannerString.nextLine();

        System.out.print("Enter card password: ");
        String cardPassword = scannerString.nextLine();

        System.out.print("Enter card balance: ");
        Double amount = scannerInt.nextDouble();

        Card card = new Card(cardName, cardNumber, expiryDate, cardPassword, amount);
        Users usersWithCard = new Users();
        usersWithCard.setCards(List.of(card));

        if (cardService.addCard(usersWithCard) != null) {
            System.out.println("Card added successfully.");
        }
    }
}