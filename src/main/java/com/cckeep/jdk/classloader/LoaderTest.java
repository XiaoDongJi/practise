package com.cckeep.jdk.classloader;


import sun.misc.Launcher;

import java.net.URL;

public class LoaderTest {

    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url:urLs){
            System.out.println(url.toExternalForm());
        }
    }

}
