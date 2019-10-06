package com.trilogyed.glossary.controller;

import com.trilogyed.glossary.model.Definition;
import com.trilogyed.glossary.util.feign.DefinitionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/glossary")
public class GlossaryController {

    @Autowired
    DefinitionClient client;

    @GetMapping("/term/{term}")
    public List<Definition> getDefinitionsByTerm(@PathVariable String term) {
        return client.getDefinitionsFromService(term);
    }

}
