package com.tg.spring5.controller;

import com.tg.spring5.model.Pet;
import com.tg.spring5.service.CrudService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pet")
public class PetController {

    private final CrudService<Pet, Long> crudService;

    public PetController(CrudService<Pet, Long> crudService) {
        this.crudService = crudService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    String index() {
        return "pet/index";
    }
}
