package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Producto;
import com.example.repository.ProductoRepository;



@Service
public class ProductoServiceImpl implements ProductoService{

     @Autowired
     private ProductoRepository productoRepository;

    //Metodo para obtener todos los productos
    @Override
    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }

    //Metodo para obtener un producto por id
    @Override
    public Optional<Producto> obtenerProductoById(Long id){
        return productoRepository.findById(id);
    }

    /*
     * Metodos exigidos por la rubrica
     * 
     * agregar, modificar, eliminar
     */

    //Agregar o Modificar funcionan similar.

     //Crear Productos
    @Override
    public Producto creaProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto guardarProducto(Long id, Producto producto) {
        if(productoRepository.existsById(id)){
            producto.setIdProd(id);
            return productoRepository.save(producto);
        }
        return null;
        
    }

    public void eliminarProducto(Long id){
        productoRepository.deleteById(id);
    }
   
}

