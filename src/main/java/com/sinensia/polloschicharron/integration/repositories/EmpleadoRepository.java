package com.sinensia.polloschicharron.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.polloschicharron.business.model.Empleado;
import com.sinensia.polloschicharron.business.model.dtos.EmpleadoDTO1;
import com.sinensia.polloschicharron.business.model.dtos.EmpleadoDTO2;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

	@Query("SELECT new com.sinensia.polloschicharron.business.model.dtos.EmpleadoDTO1(             "
			+ "e.nombre,                                                                           "
			+ "CONCAT(e.apellido1, COALESCE(CONCAT(' ', e.apellido2), '')),                        "
			+ " e.licenciaManipuladorAlimentos)                                                    "
			+ "FROM Empleado e                                                                     ")
	List<EmpleadoDTO1> findDTO1();
	
	@Query("SELECT new com.sinensia.polloschicharron.business.model.dtos.EmpleadoDTO2(              "
			+ " UPPER(CONCAT (e.apellido1, COALESCE(CONCAT(' ', e.apellido2), ''), ', ', e.nombre)),"
			+ " e.datosContacto.telefono,                                                           "
			+ " e.datosContacto.email)                                                              "
			+ "FROM Empleado e                                                                      ")
	List<EmpleadoDTO2> findDTO2();
	
}
