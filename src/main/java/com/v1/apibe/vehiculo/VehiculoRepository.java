package com.v1.apibe.vehiculo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository  extends CrudRepository<Vehiculo, Integer>{
  
}
