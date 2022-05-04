package com.spring.player;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext("com.spring.player");
        EventDetails eventDetails=(EventDetails) context.getBean("eventDetails",EventDetails.class);
//        System.out.println("eventDetails = " + eventDetails);
//        for (String event:eventDetails.printEvent()) {
//            System.out.println(event);
//        }
    }

}
