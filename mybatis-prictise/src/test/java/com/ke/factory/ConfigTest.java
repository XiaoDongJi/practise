package com.ke.factory;

import com.ke.mapper.Role;
import com.ke.mapper.RoleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ConfigTest {

    SqlSession sqlSession;

    @BeforeEach
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();

    }


    @Test
    public void getRole(){
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role role = mapper.getRole(1L);
        System.out.println(role);
        Assertions.assertNotNull(role);
    }

    @Test
    public void getById(){
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role role = mapper.getRole(2L);
        System.out.println(role);
        Assertions.assertNotNull(role);
    }

    @Test
    public void insert(){
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role role = new Role();
        role.setId(2L);
        role.setRoleName("悟空");
        role.setNote("西游记");
        mapper.insert(role);
        sqlSession.commit();
        System.out.println(role);
        Assertions.assertNotNull(role);
    }


    @AfterEach
    public void teardown(){
        sqlSession.close();
    }


}
