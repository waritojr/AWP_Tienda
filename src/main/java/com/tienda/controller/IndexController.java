package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import java.util.Arrays;
import lombok.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {

    // Se crea en tiempo de ejecucion si aun no se ha creado...
    @Autowired
    private ClienteDao clienteDao;
    
    @GetMapping("/")
    public String inicio(Model model) {
        
        log.info("Ahora se usa arquitectura MVC");
        
        /*
        Cliente cliente1 = new Cliente("Pedro","Contreras Abarca","pabarca@gmail.com","8989-9898");
        Cliente cliente2 = new Cliente("Rebeca","Arguedas Alfaro","rb@gmail.com","8489-9898");
        Cliente cliente3 = new Cliente("Juan","Dominguez","jdom@gmail.com","8389-9898");
        
        var clientes = Arrays.asList(cliente1,cliente2,cliente3);
        */
        
        // "FindAll" Va a leer todo el cursor y lo devuelve en un ArrayList
        var clientes = clienteDao.findAll();
        
        model.addAttribute("clientes",clientes);
        
        return "index";
    }
}
