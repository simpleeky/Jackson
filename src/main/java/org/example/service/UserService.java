package org.example.service;

import lombok.Getter;
import org.example.model.User;
import org.example.model.Users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final String PATH = "/Users/davronmahmarajabov/Desktop/demo/Jackson/users.xml";
    @Getter
    private static List<User> users = new ArrayList<>();
    public XmlService<User> xmlService;

    public UserService() {
        xmlService = new XmlService<>();
        try {
            users = xmlService.readXml(PATH, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public Users addUser(Users usersFrom) throws IOException {
        for (User user : usersFrom.getUsers()) {
            if (login(user.getUsername(), user.getPassword()) != null) {
                return null;
            }
        }
        users.addAll(usersFrom.getUsers());
        xmlService.writeXml(PATH, users);
        return usersFrom;
    }
}

