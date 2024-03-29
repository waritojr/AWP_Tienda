package com.tienda.controller;

import com.tienda.domain.Articulo;
import com.tienda.service.ArticuloService;
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
public class ArticuloController {

    // Se crea en tiempo de ejecucion si aun no se ha creado...
    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/articulo/listado")
    public String inicio(Model model) {

        log.info("Ahora SI se usa arquitectura MVC");

        // "FindAll" Va a leer todo el cursor y lo devuelve en un ArrayList
        var articulos = articuloService.getArticulos(false);

        model.addAttribute("articulos", articulos);

        return "articulo/listado";

    }

    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo, Model model) {

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        return "articulo/modificar";
    }

    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo) {

        articuloService.save(articulo);

        return "redirect:/articulo/listado";
    }

    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {

        articulo = articuloService.getArticulo(articulo);
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute(articulo);
        return "articulo/modificar";
    }

    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo) {

        articuloService.delete(articulo);

        return "redirect:/articulo/listado";
    }

}
