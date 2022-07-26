package com.v1.apibe.vehiculo;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

  @Autowired
  private VehiculoService vehiculoService;

  // GET
  @GetMapping
  public ArrayList<Vehiculo> getVehiculo() {
    return this.vehiculoService.getVehiculo();
  }

  // GET BY ID
  @GetMapping(path = "/{id}")
  public Optional<Vehiculo> getVehiculoById(@PathVariable("id") int id) {
    return this.vehiculoService.getVehiculoById(id);
  }
  // POST

  @PostMapping()
  public void createVehiculo(@RequestBody Vehiculo vehiculo) {
    try {
      this.vehiculoService.createVehiculo(vehiculo);
      log.info("Creado con exito");
    } catch (Exception e) {
      log.error("Error al crear");
    }

  }

  // PUT
  @PutMapping(path = "/{id}")
  public Vehiculo updateVehiculo(@PathVariable("id") int id, @RequestBody Vehiculo updatedVehiculo) {
    return this.vehiculoService.getVehiculoById(id)
        .map(vehiculo -> {
          vehiculo.setNombre(updatedVehiculo.getNombre());
          vehiculo.setMarca(updatedVehiculo.getMarca());
          vehiculo.setModelo(updatedVehiculo.getModelo());
          return this.vehiculoService.createVehiculo(vehiculo);
        }).orElseGet(() -> {
          updatedVehiculo.setIdVehiculo(id);
          return this.vehiculoService.createVehiculo(updatedVehiculo);
        });
  }

  // DELETE
  @DeleteMapping(path = "/{id}")
  public void deleteVehiculoById(@PathVariable("id") int id) {
    boolean ok = this.vehiculoService.deleteVehiculoById(id);
    if (ok) {
      log.info("Successfully deleted");
    } else {
      log.error("Error deleting");

    }
  }

}
