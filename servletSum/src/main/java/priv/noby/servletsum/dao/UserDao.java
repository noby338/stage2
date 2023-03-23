package priv.noby.servletsum.dao;

import priv.noby.servletsum.entity.User;

/**
 * @author Noby
 * @since 2022/10/6
 */
public interface UserDao {
    int insert (User user) ;
    User queryById(int id);
    User queryByUser(User user);
}
