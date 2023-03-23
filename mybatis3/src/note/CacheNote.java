package note;

import note.dao.EmpDao;
import note.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Description mybatis缓存
 * 通过log4j日志查看是否命中缓存
 * @Author Noby
 * @Date 2023/3/21 17:50
 */
public class CacheNote {
    public static void main(String[] args) {
        //region 一级缓存(session缓存)(默认开启)
        /*
        mybatis为了减少查询次数、提高执行效率它提供了两个缓存(下一个相同数据的查询不再执行SQL语句，而是直接读取上一个缓存记录)
            每一个session都有一个自己的缓存，用来临时存放查询到的数据
            mybatis在查询数据时，是先会去对应的session查询是否有需要的数据，如果有则直接获取到就不再执行SQL
            如果没有则执行SQL，然后将查询到的数据放到对应的session缓存中

            清空session缓存的方式1：
            sqlSession.clearCache();
            清空session缓存的方式2：
            sqlSession.commit();
        */

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpDao EmpDao = sqlSession.getMapper(EmpDao.class);
        System.out.println("第一次查询selectEmpById2(1)---------------");
        System.out.println("EmpDao.selectEmpById2(1) = " + EmpDao.selectEmpById2(1));

        System.out.println("第一次查询selectEmpById2(2)---------------");
        System.out.println("EmpDao.selectEmpById2(2) = " + EmpDao.selectEmpById2(2));

        System.out.println("第二次查询selectEmpById2(2)---------------");
        System.out.println("EmpDao.selectEmpById2(2) = " + EmpDao.selectEmpById2(2));

        System.out.println("第二次查询selectEmpById2(1)---------------");
        System.out.println("EmpDao.selectEmpById2(1) = " + EmpDao.selectEmpById2(1));
        //endregion


        //region 二级缓存(factory缓存)(mapper中指定开启)
        /*
            每一个SqlSessionFactory都有一个缓存，
            同一个工厂创建出来的session是可以共享二级缓存中数据的

            存放到二级缓存的方式：
            <!-- mapper标签里加上cache标签之后表示当前mapper中产生的数据是"可以"被放到二级缓存中 -->
            <cache readOnly="true"></cache>
            session.commit()之后才会存放到二级缓存
        */
        sqlSession.commit();//commit后才会存放到factory缓存
        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        EmpDao EmpDao2 = sqlSession2.getMapper(EmpDao.class);

        System.out.println("第三次查询selectEmpById2(1)(不同的sqlSession)---------------");
        System.out.println("EmpDao.selectEmpById2(1) = " + EmpDao2.selectEmpById2(1));
        //endregion

        sqlSession.close();
    }
}

