package br.com.deliverit.desafio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class DesafioApplicationTests {

    @MockBean
    private SpringApplicationBuilder springApplicationBuilder;

    @Test
    void contextLoads() {
        ServletInitializer servletInitializer = new ServletInitializer();
        when(springApplicationBuilder.sources(DesafioApplication.class)).thenReturn(springApplicationBuilder);

        SpringApplicationBuilder result = servletInitializer.configure(springApplicationBuilder);

        verify(springApplicationBuilder).sources(DesafioApplication.class);
        Assertions.assertEquals(springApplicationBuilder,result);
    }

}
