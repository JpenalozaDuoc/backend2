package com.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

/**
 * Entidad que representa la tabla "producto" en la base de datos.
 */
@Entity
@Table(name = "producto")
public class Producto {

    /**
     * Identificador único del producto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprod", nullable = false, updatable = false)
    private Long idProd;

    /**
     * Nombre del producto.
     */
    @NotNull(message = "El nombre del producto no puede estar vacío.")
    @Size(min = 5, max = 50, message = "El nombre debe tener entre 6 y 50 caracteres.")
    @Column(name = "nomproducto", nullable = false)
    private String nomProducto;

    /**
     * Precio de compra del producto.
     */
    @NotNull(message = "El precio de compra es obligatorio.")
    @Digits(integer = 10, fraction = 2, message = "El precio debe tener hasta 10 dígitos enteros y 2 decimales.")
    @Column(name = "preciocompra", nullable = false)
    private BigDecimal precioCompra;

    // Constructor vacío
    public Producto() {}

    // Getters y Setters
    public Long getIdProd() {
        return idProd;
    }

    public void setIdProd(Long idProd) {
        this.idProd = idProd;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    // toString
    @Override
    public String toString() {
        return "Producto{" +
                "idProd=" + idProd +
                ", nomProducto='" + nomProducto + '\'' +
                ", precioCompra=" + precioCompra +
                '}';
    }
}