package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
import java.util.Arrays;
import lombok.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class IndexController {

    // Se crea en tiempo de ejecucion si aun no se ha creado...
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public String inicio(Model model) {

        log.info("Ahora SI se usa arquitectura MVC");

        /*
        Cliente cliente1 = new Cliente("Pedro","Contreras Abarca","pabarca@gmail.com","8989-9898");
        Cliente cliente2 = new Cliente("Rebeca","Arguedas Alfaro","rb@gmail.com","8489-9898");
        Cliente cliente3 = new Cliente("Juan","Dominguez","jdom@gmail.com","8389-9898");
        
        var clientes = Arrays.asList(cliente1,cliente2,cliente3);
         */
        // "FindAll" Va a leer todo el cursor y lo devuelve en un ArrayList
        var clientes = clienteService.getClientes();

        model.addAttribute("clientes", clientes);

        return "index";

    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente) {

        return "modificarCliente";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente) {

        clienteService.save(cliente);

        return "redirect:/";
    }
    
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {

        cliente = clienteService.getCliente(cliente);
        model.addAttribute(cliente);
        return "modificarCliente";
    }
    
    @GetMapping("/eliminarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente) {

        clienteService.delete(cliente);
        
        return "redirect:/";
    }
    
}
