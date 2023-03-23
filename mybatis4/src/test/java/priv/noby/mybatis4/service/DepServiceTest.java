package priv.noby.mybatis4.service;

import org.junit.Test;

/**
 * @author Noby
 * @since 2022/9/16
 */
public class DepServiceTest {
    DepService depService = new DepService();

    @Test
    public void selectAll() {
        System.out.println("depService.selectAll() = " + depService.selectAll());
    }

    @Test
    public void selectById() {
        System.out.println("depService.selectById(1) = " + depService.selectById(1));
    }
}