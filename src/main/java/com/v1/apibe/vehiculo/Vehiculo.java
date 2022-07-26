package com.v1.apibe.vehiculo;

import javax.persistence.*;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false, name = "id_vehiculo")
  private Integer idVehiculo;

  private String nombre;

  private String marca;

  private String modelo;


  public Vehiculo() {
  }
  
  public Vehiculo(String nombre, String marca, String modelo) {
    this.nombre = nombre;
    this.marca = marca;
    this.modelo = modelo;
  }

  public Integer getIdVehiculo() {
    return idVehiculo;
  }

  public void setIdVehiculo(Integer idVehiculo) {
    this.idVehiculo = idVehiculo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }


  
}
