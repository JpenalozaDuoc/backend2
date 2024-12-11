package com.example.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Producto;
import com.example.service.ProductoService;

import org.springframework.web.bind.annotation.CrossOrigin;
//import com.tienda.yisus.tienda_duoc.exception.ResourceNotFoundException;
//import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {
    /*
    * Definir Micro Servicio 2
    * Get obtenerProducto();
    * Post crearProducto();
    * Put actualizaProducto();
    * Delete borraProducto();
    */
    @Autowired
    private ProductoService productoService;

    //get
    @GetMapping
    /*public List<Producto> getAllProducts() {
        return productoService.listarProductos();
    }*/
    public ResponseEntity<List<Producto>> obtieneProdutos() {
        List<Producto> productos =  productoService.listarProductos();
        return ResponseEntity.ok(productos);
    }

    
    @GetMapping("/{id}")
    public Optional<Producto> getProductById(@PathVariable Long id) {
        return productoService.obtenerProductoById(id);
    }
    /*
    public ResponseEntity<Producto> buscaProductoPorId(@PathVariable Long id){
        Producto producto = productoService.obtenerProductoById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Producto "+id+" No encontrado"));
        return ResponseEntity.ok(producto);
    }
    */

    //post
    @PostMapping
    /*
    public Producto createProduct(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }*/
    public ResponseEntity<Producto> creaProducto(@RequestBody Producto addProd) {
        Producto producto = productoService.creaProducto(addProd);
        return new ResponseEntity<>(producto, HttpStatus.CREATED);//Devolverá 201 Created
    }
    

    //put
    @PutMapping("/{id}")
    
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.guardarProducto(id,producto);
    }
   /*
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id,@Valid  @RequestBody Producto detallesProducto) {
        Producto producto = productoService.obtenerProductoById(id)
            .orElseThrow(()-> new ResourceNotFoundException("El producto "+id+" No fue encontrado"));
            producto.setNomProducto(detallesProducto.getNomProducto());
            producto.setPrecioCompra(detallesProducto.getPrecioCompra());
            Producto productoActualizado = productoService.guardarProducto(producto);
            return ResponseEntity.ok(productoActualizado);
        
    }
     */
    //delete
    @DeleteMapping("/delete/{id}")
    public void borraProducto(@PathVariable Long id){
        productoService.eliminarProducto(id);
    }

}

