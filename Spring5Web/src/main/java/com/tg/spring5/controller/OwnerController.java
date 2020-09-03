package com.tg.spring5.controller;

import com.tg.spring5.model.Owner;
import com.tg.spring5.service.CrudService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("owner")
public class OwnerController {

    private final CrudService<Owner, Long> crudService;

    public OwnerController(CrudService<Owner, Long> crudService) {
        this.crudService = crudService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    String index() {
        return "owner/index";
    }
}
