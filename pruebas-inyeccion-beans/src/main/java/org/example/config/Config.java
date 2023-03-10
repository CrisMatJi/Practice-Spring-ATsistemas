package org.example.config;


import org.example.clases.NombreImpl;
import org.example.interfaces.HelloService;
import org.example.interfaces.NombreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class Config {

    @Bean
    public NombreService nombreImpl()
    {
        return new NombreImpl();
    }


}
