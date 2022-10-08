package note.dao;

import note.entity.ClassTeacherMap;
import note.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClassTeacherDaoTest {
    SqlSession sqlSession = null;
    ClassTeacherMapDao classTeacherMapDao = null;

    @Before
    public void setUp() {
        sqlSession = SqlSessionUtil.getSqlSession();
        classTeacherMapDao = sqlSession.getMapper(ClassTeacherMapDao.class);
    }

    @After
    public void tearDown() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    /**
     * 多对多一次查询
     */
    @Test
    public void selectClaTeaByCtid() {
        ClassTeacherMap class_teacher = classTeacherMapDao.selectClaTeaByCtid(5);
        System.out.println(class_teacher);
    }

    /**
     * 多对多分步查询
     */
    @Test
    public void selectClaTeaByCtid2() {
        ClassTeacherMap class_teacher = classTeacherMapDao.selectClaTeaByCtid2(5);
        System.out.println(class_teacher);
    }

}