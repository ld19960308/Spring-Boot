package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.sun.corba.se.spi.activation.Repository;


@EnableAutoConfiguration
@ComponentScan(basePackages={"com.dao.*","com.config.*"})
public class Application {
       public static void main(String[] args){
    	   ConfigurableApplicationContext ctx=SpringApplication.run(Application.class, args);
    	   System.out.println(ctx.getBeanDefinitionCount());
    	   for(String c:ctx.getBeanNamesForType(Repository.class)){
    		   System.out.println(c);
    	   }
    	   //UserRepository userRepository=(UserRepository) ctx.getBean("userRepository");
    	   //Optional<User> user=userRepository.findById("1");
    	   //if(user.isPresent()){
    	//	   System.out.println(user.get().getName());
    	  // }
       }
}
