package com.tutorial.dynamocrud;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@DynamoDBTable(tableName = "inventario")
public class Propiedad {

    @DynamoDBHashKey
    private int id;

    @DynamoDBAttribute
    private String nombre;

    @DynamoDBAttribute
    private String precio;

    @DynamoDBAttribute(attributeName = "tipo")
    private String tipo;

    @DynamoDBAttribute(attributeName = "transaccion")
    private String transaccion;

    @DynamoDBAttribute(attributeName = "metros_cuadrados")
    private String metrosCuadrados;

    @DynamoDBAttribute(attributeName = "direccion")
    private String direccion;

    @DynamoDBAttribute(attributeName = "ciudad")
    private String ciudad;

    @DynamoDBAttribute(attributeName = "departamento")
    private String departamento;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public String getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(String metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @DynamoDBAttribute(attributeName = "estado")
    private String estado;

    @DynamoDBAttribute(attributeName = "descripcion")
    private String descripcion;

    public Propiedad() {
        this.id = ThreadLocalRandom.current().nextInt();
    }

    public Propiedad(int id, String nombre, String precio) {
        this();
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
