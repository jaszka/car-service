package org.playground.carservice;

import org.playground.carservice.domain.CarServiceAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class CarServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(CarServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

    @Bean
    ApplicationRunner interactiveRunner(CarServiceAgent agent) {
        return args -> {
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    log.info("Hello, how can I help you?: ");
                    String userQuery = scanner.nextLine();

                    if ("exit".equalsIgnoreCase(userQuery)) {
                        break;
                    }

                    String agentAnswer = agent.answer(userQuery);
                    log.info("Agent: {}", agentAnswer);
                }
            }
        };
    }
}
