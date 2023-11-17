package com.lzh.Mybatis.Test;

import com.lzh.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class CarMapperTest {
    private static final Logger LOGGER = Logger.getLogger(CarMapperTest.class.getName());

    @Test
    public void testInsertCarByUtil() {
        try (SqlSession sqlSession = SqlSessionUtil.openSession()) {
            int count = sqlSession.insert("insertCar");
            System.out.println("Affected rows: " + count);

            // Assertion: Verify that the number of affected rows is greater than zero
            assertTrue(count > 0);

            sqlSession.commit();
        } catch (Exception e) {
            handleException(e);
        }
    }

    @Test
    public void testInsertCar() {
        try (SqlSession sqlSession = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml")).openSession()) {

            int count = sqlSession.insert("insertCar");
            System.out.println("Affected rows: " + count);

            // Assertion: Verify that the number of affected rows is greater than zero
            assertTrue(count > 0);

            sqlSession.commit();

        } catch (IOException | RuntimeException e) {
            handleException(e);
        }
    }

    private void handleException(Exception e) {
        if (e instanceof IOException) {
            LOGGER.log(Level.SEVERE, "IOException occurred: " + e.getMessage(), e);
        } else if (e instanceof RuntimeException) {
            LOGGER.log(Level.SEVERE, "RuntimeException occurred: " + e.getMessage(), e);
        }

        // If you need to rollback in case of an exception, you can do it here.
        // Example: sqlSession.rollback();
    }
}
