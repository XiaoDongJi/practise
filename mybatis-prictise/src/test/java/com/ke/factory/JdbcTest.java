package com.ke.factory;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.jdbc.SqlRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.*;
import java.util.Map;

/**
 * @author: jixd
 * @date: 2020/7/15 6:16 下午
 */
public class JdbcTest {

    Connection connection;
    @BeforeEach
    public void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai", "root", "root1234");
    }

    @Test
    public void insert() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into t_role (role_name,note) values ('哈啤','good')",Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()){
            int anInt = generatedKeys.getInt(1);
            System.out.println(anInt);
        }
    }

    @Test
    public void getMetadata() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println(metaData.getSchemas());

    }


    @Test
    public void scriptTest() throws SQLException {
        SqlRunner sqlRunner = new SqlRunner(connection);
        SQL sql = new SQL().SELECT("*").FROM("t_role").WHERE("id = 3");

        Map<String, Object> stringObjectMap = sqlRunner.selectOne(sql.toString());
        System.out.println(stringObjectMap);

    }



    @AfterEach
    public void teardown() throws SQLException {
        if (connection != null){
            connection.close();
        }
    }

}
