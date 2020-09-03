package com.tg.spring5.controller;

import com.tg.spring5.model.Vet;
import com.tg.spring5.service.CrudService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vet")
public class VetController {

    private final CrudService<Vet, Long> crudService;

    public VetController(CrudService<Vet, Long> crudService) {
        this.crudService = crudService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    String index() {
        return "vet/index";
    }
}
