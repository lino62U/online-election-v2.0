package org.system.onlineelection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.system.onlineelection.application.service.CandidateServiceImpl;

@SpringBootTest(classes = MainApplication.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class WebConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CandidateServiceImpl candidateService;

    @Test
    public void testAuthenticatedRequestToAuthEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/auth/all-candidate"))
               .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void testLogin() throws Exception {
        String requestBody = "{\"userName\": \"aldito\", \"password\": \"12345\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                .contentType("application/json")
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
    }
}
