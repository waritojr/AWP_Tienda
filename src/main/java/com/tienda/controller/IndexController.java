package com.tienda.controller;

import com.tienda.service.ArticuloService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {

    // Se crea en tiempo de ejecucion si aun no se ha creado...
    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/")
    public String inicio(Model model) {  
        
        var articulos = articuloService.getArticulos(true);

        model.addAttribute("articulos", articulos);

        return "index";

    }

    
    
}
