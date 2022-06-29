package com.example.webservicerestfulreativo.hello;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
// Criamos um `@SpringBootTest`, iniciando um servidor real em um `RANDOM_PORT`
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingRouterTest {
    // Spring Boot criará um `WebTestClient` para você,
    // já configurado e pronto para emitir requisições em "localhost:RANDOM_PORT"
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testHello(){
        webTestClient.get().uri("/hello")
                // Cria uma solicitação GET para testar um endpoint
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Greeting.class).value(greeting -> {
                    assertThat(greeting.getMessage()).isEqualTo("Hello, Spring!");
                });
    }
}
