package org.example.web.controller;

import org.example.web.service.CompoentA;
import org.example.web.service.CompoentB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/components")
public class ComponentController {
    @Autowired
    CompoentA compoentA;

    @Autowired
    @Qualifier("componentBWithKeyA")
    CompoentB compoentBa;

    @Autowired
    @Qualifier("componentBWithKeyB")
    CompoentB compoentBb;

    @GetMapping("")
    public String get() {
        return String.format("%s\n%s\n%s", compoentA.getName(), compoentBa.getName(), compoentBb.getName());
    }

}
