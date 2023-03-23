package priv.noby.listener.service;

import priv.noby.listener.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User("noby","1"));
        users.add(new User("kace","1"));
        users.add(new User("july","1"));
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
