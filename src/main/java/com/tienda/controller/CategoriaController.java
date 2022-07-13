package com.tienda.controller;

import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import lombok.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CategoriaController {

    // Se crea en tiempo de ejecucion si aun no se ha creado...
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria/listado")
    public String inicio(Model model) {

        log.info("Ahora SI se usa arquitectura MVC");
        
        // "FindAll" Va a leer todo el cursor y lo devuelve en un ArrayList
        var categorias = categoriaService.getCategorias(false);

        model.addAttribute("categorias", categorias);

        return "categoria/listado";

    }

    @GetMapping("/categoria/nuevo")
    public String nuevoCategoria(Categoria categoria) {

        return "categoria/modificar";
    }

    @PostMapping("/categoria/guardar")
    public String guardarCategoria(Categoria categoria) {

        categoriaService.save(categoria);

        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/categoria/modificar/{idCategoria}")
    public String modificarCategoria(Categoria categoria, Model model) {

        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute(categoria);
        return "categoria/modificar";
    }
    
    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String eliminarCategoria(Categoria categoria) {

        categoriaService.delete(categoria);
        
        return "redirect:/categoria/listado";
    }
    
}
