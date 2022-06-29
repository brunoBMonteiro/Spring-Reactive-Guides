package com.example.webservicerestfulreativo;

import com.example.webservicerestfulreativo.hello.GreetingClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebservicerestfulreativoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
        SpringApplication.run(WebservicerestfulreativoApplication.class, args);
        GreetingClient greetingClient = context.getBean(GreetingClient.class);
        // Precisamos bloquear o conteúdo aqui ou a JVM pode sair antes que a mensagem seja registrada
        System.out.println(">> message = " + greetingClient.getMessage().block());
    }

}
