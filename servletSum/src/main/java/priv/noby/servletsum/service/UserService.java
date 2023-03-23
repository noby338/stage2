package priv.noby.servletsum.service;

import priv.noby.servletsum.entity.User;

public interface UserService {
    User insert(User user);
    User queryById(int id);
    User queryByUser(User user);
}
