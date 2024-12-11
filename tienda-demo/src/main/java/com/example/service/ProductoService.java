package com.example.service;

import java.util.List;
import java.util.Optional;
import com.example.model.Producto;

public interface ProductoService {

    /*
     * Un microservicio para la gestión de productos (agregar, modificar, eliminar).
     * 
     */

    //Metodo para obtener todos los productos
    List<Producto> listarProductos();

    //Metodo para obtener un producto por id
    Optional<Producto> obtenerProductoById(Long id);

    /*
     * Metodos exigidos por la rubrica
     * 
     * agregar, modificar, eliminar
     */

    //Crear Productos
    Producto creaProducto(Producto producto);
    
    //Agregar o Modificar funcionan similar.
    Producto guardarProducto(Long id, Producto producto);

    void eliminarProducto(Long id);


}
