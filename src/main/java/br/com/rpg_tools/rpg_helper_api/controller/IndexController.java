package br.com.rpg_tools.rpg_helper_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class IndexController {

    @GetMapping("/")
    public Map<String, String> index() {
        return Map.of(
                "message", "API RPG Helper está rodando 🚀",
                "developer", "Gustavo Vinicios de Santana Xavier",
                "github", "https://github.com/Gustavo-Vinicius-Santana",
                "linkedin", "https://www.linkedin.com/in/gustavo-vinicius-596005276/"
        );
    }
}