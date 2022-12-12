package br.com.xbrain.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VendaControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deve salvar uma venda")
    void deveSalvarVenda() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/venda")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "vendedorId": 10000,
                                    "produtosIds": [10000, 20000]
                                }
                                """)
                )
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    @DisplayName("Não deve salvar venda quando request for inválida")
    void naoDeveSalvarVendaQuandoRequestForInvalida() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/venda")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                }
                                """)
                )
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    @DisplayName("Não deve salvar venda quando vendedor for inválido")
    void naoDeveSalvarVendaQuandoVendedorForInvalido() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/venda")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "vendedorId": 6666,
                                    "produtosIds": [10000, 20000]
                                }
                                """)
                )
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    @DisplayName("Não deve salvar venda quando produtos forem inválidos")
    void naoDeveSalvarVendaQuandoProdutosForemInvalidos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/venda")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "vendedorId": 10000,
                                    "produtosIds": [6666, 7777]
                                }
                                """)
                )
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}