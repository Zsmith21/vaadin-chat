package com.vaadin.starter.skeleton.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;

import java.time.Duration;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
public class ChatApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ChatApp.class, args);
    }

    @Bean
    public UnicastProcessor<ChatMessage> messagePublisher(){
        return UnicastProcessor.create();
    }

    @Bean
    public Flux<ChatMessage> messages(UnicastProcessor<ChatMessage> eventPublisher) {
        return eventPublisher
            .replay(20)
            .autoConnect();
    }

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(ChatApp.class);
    }

}
