
package com.tienda.service;

import com.tienda.domain.Item;
import java.util.List;
import java.util.Objects;
import lombok.var;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{

    @Override
    public List<Item> getItems() {
        
        return listaItems;
    }

    @Override
    public void save(Item item) {
        
        boolean existe = false;
        for (Item c : listaItems) {
            
            // Busca si ya existe el articulo en el carrito
            
            if (Objects.equals(c.getIdArticulo(), item.getIdArticulo())) {
                
                // Valida si aun puede colocar un item adicional -segun existencias-
                
                if (c.getCantidad() < item.getExistencias()) {
                    
                    // Incrementa en 1 la cantidad de elementos
                    c.setCantidad(c.getCantidad() + 1);
                }
                
                existe = true;
                break;
            }
        }
        
        if (!existe) { //Si no esta el articulo en el carrito entonces lo agrega cantidad = 1
            
            item.setCantidad(1);
            listaItems.add(item);
        }
        
    }

    @Override
    public void delete(Item item) {
        
        var posicion = -1;
        var existe = false;
        for (Item c : listaItems) {
            
            ++posicion;
            
            if (Objects.equals(c.getIdArticulo(), item.getIdArticulo())) {
                
                existe = true;
                break;
            }
        }
    }

    @Override
    public Item getItem(Item item) {
        
        for (Item c : listaItems) {
            
            if (Objects.equals(c.getIdArticulo(), item.getIdArticulo())) {
                
                return c;
            }
            
        }
        
        return null;
    }
    
    @Override
    public void actualiza(Item item) {
        
        for (Item i : listaItems) {
            
            if (Objects.equals(i.getIdArticulo(), item.getIdArticulo())) {
                
                i.setCantidad(item.getCantidad());
                
                break;
            }
        }
        
    }
    

    @Override
    public void facturar() {
        
        for (Item i : listaItems) {
            
            //Porceso de facturacion
        }
        
        listaItems.clear();
    }


    
    
    

}
