package com.cckeep.jdk.classloader;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        /*URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url:urLs){
            System.out.println(url.toExternalForm());
        }*/



        MyClassLoader classLoader = new MyClassLoader();
        //<?> aClass = Class.forName("Person", true, classLoader);
        Class<?> aClass = classLoader.findClass("Person");
        Object o = aClass.newInstance();
        System.out.println(o);
        System.out.println(o.getClass().getClassLoader());


        String time = "2018-04-09T09:05:01.532Z";

        LocalDateTime localDateTime = LocalDateTime.parse(time,DateTimeFormatter.ISO_ZONED_DATE_TIME);
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm")));
    }

}
