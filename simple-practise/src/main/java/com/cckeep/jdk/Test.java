package com.cckeep.jdk;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <p>TODO</p>
 *
 * @author jixd
 * @Date Created in 2018年11月27日 11:54
 */
public class Test {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);

        //新增部分
        Set<Integer> set2  = new HashSet<>();
        set2.add(2);
        set2.add(3);
        //删除部分
        Set<Integer> set3 = new HashSet<>();
        set3.addAll(set1);

        set3.removeAll(set2);
        set2.removeAll(set1);

        System.out.println(set1.removeAll(set3));
        System.out.println(set1.addAll(set2));
        System.out.println(set1);
        try {
            test();
        }catch (Exception e){
            System.out.println(e);
        }

        AtomicBoolean atomicBoolean = new AtomicBoolean(true);

        while (true){
            if (!atomicBoolean.get()){
                System.out.println();
                break;
            }

        }
    }


    public static void test(){
        System.out.println("111111");
        throw new IllegalArgumentException("参数错误");
    }

}
