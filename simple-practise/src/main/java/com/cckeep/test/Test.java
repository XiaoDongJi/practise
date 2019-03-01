package com.cckeep.test;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws InterruptedException {
       /* Map<Long, Set<Long>> resbBuildingIds = Maps.newHashMap();
        Set<Long> h1 = Sets.newHashSet();
        h1.add(22L);
        h1.add(33L);
        Set<Long> h2 = Sets.newHashSet();
        h1.add(44L);
        h1.add(55L);
        resbBuildingIds.put(1l,h1);
        resbBuildingIds.put(2l,h2);
        Set<String> collect = resbBuildingIds.values().stream().flatMap(Collection::stream).map(String::valueOf).collect(Collectors.toSet());
        System.out.println(collect);


        for (int i = 0; i < 5; i++) {
            System.out.println(3333);
            for (int j = 0; j < 3; j++) {
                System.out.println(11111);
                break;
            }

        }*/


        System.out.println(Math.pow(3,2));
    }

}
