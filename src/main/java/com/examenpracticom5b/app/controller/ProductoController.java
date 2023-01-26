package com.examenpracticom5b.app.controller;

import com.examenpracticom5b.app.model.Producto;
import com.examenpracticom5b.app.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/listarproducto")
    public ResponseEntity< List<Producto>> obtenerLista() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crearproducto")
    public ResponseEntity<Producto> crear(@RequestBody Producto p){
     return new ResponseEntity<>(productoService.save(p), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminarproducto/{codigo}")
    public void eliminar(@PathVariable("codigo") Integer codigo){
    	productoService.delete(codigo);
    }
    
    @PutMapping("/actualizarproducto/{codigo}")
    public ResponseEntity<Producto> actualizar(@RequestBody Producto p,@PathVariable Integer codigo){
    	Producto productoa = productoService.findById(codigo);
        productoa.setDescripcion(p.getDescripcion());
        productoa.setPrecio(p.getPrecio());
        productoa.setCantidad(p.getCantidad());
     return new ResponseEntity<>(productoService.save(productoa), HttpStatus.CREATED);
    }
    
    @GetMapping("/buscarproducto/{codigo}")
    public ResponseEntity<Producto> buscar(@PathVariable("codigo") Integer codigo) {
        return new ResponseEntity<>(productoService.findById(codigo), HttpStatus.OK);
    }
}
