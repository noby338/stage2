package note.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description 用于创建数据库链接的工具类
 * @Author Noby
 * @Date 2023/3/21 12:42
 */
public class SqlSessionUtil {
    static SqlSessionFactory sqlSessionFactory= null;
    public static SqlSession getSqlSession(){
        if (sqlSessionFactory == null) {
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        return sqlSessionFactory.openSession(false); //如果不设置参数或者参数为false就是手动提交事务，参数设置为true就是自动提交事务
    }
}
