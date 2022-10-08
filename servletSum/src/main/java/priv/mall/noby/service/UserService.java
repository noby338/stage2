package priv.mall.noby.service;

import priv.mall.noby.entity.User;

public interface UserService {
    User insert(User user);
    User queryById(int id);
    User queryByUser(User user);
}
