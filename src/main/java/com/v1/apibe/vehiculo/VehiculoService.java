package com.v1.apibe.vehiculo;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {

  @Autowired
  private VehiculoRepository vehiculoRepository;

  // GET
  public ArrayList<Vehiculo> getVehiculo() {
    return (ArrayList<Vehiculo>) this.vehiculoRepository.findAll();
  }

  // GET BY ID
  public Optional<Vehiculo> getVehiculoById(int id) {
    return this.vehiculoRepository.findById(id);
  }

  // POST
  public Vehiculo createVehiculo(Vehiculo vehiculo) {
    return this.vehiculoRepository.save(vehiculo);
  }
  // PUT

  // DELETE
  public boolean deleteVehiculoById(int id) {
    try {
      this.vehiculoRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
