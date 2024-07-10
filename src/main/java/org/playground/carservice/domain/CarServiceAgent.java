package org.playground.carservice.domain;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface CarServiceAgent {

    @SystemMessage("""
            You are a polite support agent of a company which collects data about vehicles.
            """)
    String answer(String userMessage);
}