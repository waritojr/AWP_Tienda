
package com.tienda.domain;

import lombok.Data;

@Data
public class Item extends Articulo{
    
    // Almacenar cantidad de items de un articulo
    private int cantidad;

    public Item() {
    }
    
    public Item(Articulo articulo) {
        
        super.setIdArticulo(articulo.getIdArticulo());
        super.setIdCategoria(articulo.getIdCategoria());
        super.setDescripcion(articulo.getDescripcion());
        super.setDetalle(articulo.getDetalle());
        super.setPrecio(articulo.getPrecio());
        super.setExistencias(articulo.getExistencias());
        super.setActivo(articulo.isActivo());
        super.setRutaImagen(articulo.getRutaImagen());
        this.cantidad=0;
    }

}
