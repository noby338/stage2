package priv.mall.noby.service.impl;

import org.apache.ibatis.session.SqlSession;
import priv.mall.noby.dao.UserDao;
import priv.mall.noby.entity.User;
import priv.mall.noby.service.UserService;
import priv.mall.noby.util.MybatisUtil;

/**
 * @author Noby
 * @since 2022/10/6
 */
public class UserServiceImpl implements UserService {

    @Override
    public User insert(User user) {
        SqlSession sqlSession = null;
        UserDao mapper = null;
        sqlSession = MybatisUtil.getSqlSession();
        mapper = sqlSession.getMapper(UserDao.class);
        int id = mapper.insert(user);
        user.setId(id);
        sqlSession.commit();
        if (sqlSession != null) {
            sqlSession.close();
        }
        return user;
    }

    @Override
    public User queryById(int id) {
        SqlSession sqlSession = null;
        UserDao mapper = null;
        sqlSession = MybatisUtil.getSqlSession();
        mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.queryById(id);
        sqlSession.commit();
        if (sqlSession != null) {
            sqlSession.close();
        }
        return user;
    }

    @Override
    public User queryByUser(User user) {
        SqlSession sqlSession = null;
        UserDao mapper = null;
        sqlSession = MybatisUtil.getSqlSession();
        mapper = sqlSession.getMapper(UserDao.class);
        User userRes = mapper.queryByUser(user);
        sqlSession.commit();
        if (sqlSession != null) {
            sqlSession.close();
        }
        return userRes;
    }
}
