/// Created by BB on 2016-12-21.
package com.greenfoxacademy.java.lesson.beans;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
public class HelloWorldConfig{

    @Bean
    public HelloWorld helloWorld(){
        return new HelloWorld();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public WithFries withFries(Boolean salted){
        return new WithFries(salted);
    }

    @Bean
    public WithFries withFries(){
        return new WithFries();
    }

}