package com.ke.factory;

import com.ke.mapper.Role;
import org.apache.ibatis.executor.loader.ResultLoaderMap;
import org.apache.ibatis.executor.loader.javassist.JavassistProxyFactory;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaClass;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.session.Configuration;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;

import static org.mockito.Mockito.mock;

/**
 * @author: jixd
 * @date: 2020/7/15 8:13 下午
 */
public class MetaTest {


    @Test
    public void MetaObject(){

        Role role = new Role();
        role.setId(1L);
        role.setNote("good");
        role.setRoleName("haha");
        MetaObject metaObject = SystemMetaObject.forObject(role);
        System.out.println(metaObject.getValue("roleName"));
    }

    @Test
    public void MetaClass(){
        MetaClass metaClass = MetaClass.forClass(Role.class, new DefaultReflectorFactory());
        String[] getterNames = metaClass.getGetterNames();
        System.out.println(getterNames);

    }

    @Test
    public void ProxyFactoryTest(){
        JavassistProxyFactory javassistProxyFactory = new JavassistProxyFactory();
        Role role = new Role();
        role.setRoleName("hehe");
        ObjectFactory objectFactory = new DefaultObjectFactory();
        Object deserializationProxy = javassistProxyFactory.createDeserializationProxy(role, mock(HashMap.class)
                , objectFactory, null, null);

        System.out.println(deserializationProxy);
    }

}
