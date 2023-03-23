package note.dao.impl;

import note.dao.StudentDao2;
import note.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * mybatis注解映射
 */
public class StudentDaoTest3 {
    /**
     * 单个查询使用mybatis注解
     */
    @Test
    public void testSelectStudentById2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentDao2 mapper = sqlSession.getMapper(StudentDao2.class);
        System.out.println("mapper.selectById(3) = " +
                mapper.selectById2(3));
        sqlSession.close();
    }
}