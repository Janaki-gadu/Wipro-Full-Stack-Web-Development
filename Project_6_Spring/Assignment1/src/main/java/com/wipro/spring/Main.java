package com.wipro.spring;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main { public static void main(String[] args){ try(ClassPathXmlApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml")){ System.out.println(c.getBean("movie",Movie.class)); } } }