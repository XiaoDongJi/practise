package com.cckeep.jdk.time;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * <p>TODO</p>
 *
 * @author jixd
 * @Date Created in 2018年11月09日 10:48
 */
public class TimeMonthTest {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(2018,1,30);
        LocalDate oneDate = localDate.plusMonths(1).plusDays(-1);
        System.out.println(oneDate.toString());

        int i = new BigDecimal(Double.valueOf(351.2)).multiply(new BigDecimal(100)).intValue();
        System.out.println(i);

        int i1 = BigDecimal.valueOf(351.2).multiply(BigDecimal.valueOf(100)).setScale(0, RoundingMode.HALF_UP).intValue();
        System.out.println(i1);

    }

}
