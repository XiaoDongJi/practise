package com.ke.factory;

import org.apache.ibatis.jdbc.SQL;
import org.junit.jupiter.api.Test;

/**
 * @author: jixd
 * @date: 2020/7/15 7:35 下午
 */
public class SQLTest {

    @Test
    public void insertSql(){
        SQL values = new SQL().INSERT_INTO("PERSON")
                .VALUES("ID", "NAME");
        System.out.println(values.toString());
    }

}
