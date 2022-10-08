package note.dao;

import note.entity.Class;
import note.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClassDaoTest {
    SqlSession sqlSession = null;
    ClassDao mapper = null;

    @Before
    public void setUp() {
        sqlSession = SqlSessionUtil.getSqlSession();
        mapper = sqlSession.getMapper(ClassDao.class);
    }

    @After
    public void tearDown() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    /**
     * 中间表连表查询
     */
    @Test
    public void selectClassByCid() {
        Class aClass = mapper.selectClassById(1);
        System.out.println(aClass);
    }

    /**
     * 中间表手动映射连表查询
     */
    @Test
    public void selectClassByCid2() {
        Class aClass = mapper.selectClassById2(1);
        System.out.println(aClass);
    }

}