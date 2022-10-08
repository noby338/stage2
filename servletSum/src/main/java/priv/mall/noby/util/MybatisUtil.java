package priv.mall.noby.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSession getSqlSession(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory.openSession();
    }
}
