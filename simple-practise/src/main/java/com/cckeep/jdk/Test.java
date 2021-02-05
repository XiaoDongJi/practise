package com.cckeep.jdk;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

        LocalDateTime localDateTime = LocalDate.now().atTime(LocalTime.of(23,0,0));
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }



}
