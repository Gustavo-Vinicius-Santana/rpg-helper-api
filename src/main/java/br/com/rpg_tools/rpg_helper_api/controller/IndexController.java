package br.com.rpg_tools.rpg_helper_api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${DATABASE_URL}")
    private String databaseUrl;

    @GetMapping("/")
    public String index() {
        return "API RPG Helper está rodando 🚀\nDATABASE_URL = " + databaseUrl;
    }
}