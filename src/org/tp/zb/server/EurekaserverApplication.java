package org.tp.zb.server;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
@EnableEurekaServer
@SpringBootApplication
@Configuration
public class EurekaserverApplication {
	
	@Value("${server.port}")
	public static int port;//="80";
	
	
    public static void main(String[] args) {
//        SpringApplication.run(EurekaserverApplication.class, args);
        
     // 读取控制台输入，决定使用哪个profiles
//        Scanner scan = new Scanner(System.in);
//        String profiles = scan.nextLine();
    	
        new SpringApplicationBuilder(EurekaserverApplication.class)
        	//.web(true)
//        	.profiles(profiles)
        .profiles(args[0])
        	.run(args);
    }
    
    @Bean
    public EmbeddedServletContainerFactory servletContainer(){
        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
//        factory.setPort(port);
//        factory.setContextPath("/eureka");
        return factory;
    }
}
