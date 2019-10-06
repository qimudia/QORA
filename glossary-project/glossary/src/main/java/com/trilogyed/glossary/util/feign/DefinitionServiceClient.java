package com.trilogyed.glossary.util.feign;

import com.trilogyed.glossary.model.Definition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="definition-service")
public interface DefinitionServiceClient {

    @GetMapping("/definition/term/{term}")
    public List<Definition> getDefinitionsFromService(String term);
}
