package com.dd.bean;

import com.dd.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

/**
 * @author: jixd
 * @date: 2020/7/29 6:05 下午
 */
public class IntrospectorTest {

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {

        User user = new User();
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors){
            Method readMethod = propertyDescriptor.getReadMethod();
            Method writeMethod = propertyDescriptor.getWriteMethod();
            if (writeMethod == null){
                continue;
            }
            int parameterCount = writeMethod.getParameterCount();
            Class<?> declaringClass = writeMethod.getDeclaringClass();
            if (parameterCount == 1){
                Class<?> parameterType = writeMethod.getParameterTypes()[0];
                if (parameterType == int.class){
                    writeMethod.invoke(user,1);
                }else{
                    writeMethod.invoke(user,"1");
                }

            }
        }
        System.out.println(user);
    }


}
