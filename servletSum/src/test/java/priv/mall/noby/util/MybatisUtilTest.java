package priv.mall.noby.util;

import org.junit.Test;
import priv.noby.servletsum.util.MybatisUtil;

public class MybatisUtilTest {

    @Test
    public void testGetSqlSession() {
        System.out.println("MybatisUtil.getSqlSession() = " + MybatisUtil.getSqlSession());
    }
}