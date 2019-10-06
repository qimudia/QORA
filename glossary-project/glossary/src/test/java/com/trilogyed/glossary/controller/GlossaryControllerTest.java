package com.trilogyed.glossary.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.glossary.model.Definition;
import com.trilogyed.glossary.util.feign.DefinitionServiceClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GlossaryController.class)
public class GlossaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DefinitionServiceClient client;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getDefinitionsForTerm() throws Exception{
        Definition def = new Definition(1,"teal", "A deep blue-green color");

        List<Definition> defs = Collections.singletonList(def);

        String outputJson = mapper.writeValueAsString(defs);

        when(client.getDefinitionsForTerm(def.getTerm())).thenReturn(defs);

        this.mockMvc.perform(get("/glossary/term/teal"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
}