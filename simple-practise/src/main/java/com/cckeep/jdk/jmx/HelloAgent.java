package com.cckeep.jdk.jmx;


import javax.management.*;
import java.lang.management.ManagementFactory;

public class HelloAgent {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {

        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        ObjectName helloName = new ObjectName("jmxBean:name=hello");

        server.registerMBean(new Hello(),helloName);


        Thread.sleep(100000);

    }

}
