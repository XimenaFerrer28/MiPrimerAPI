package humbe.canciones.model.dao;

import org.springframework.data.repository.CrudRepository;

import humbe.canciones.model.entity.cliente;

public interface ClienteDao extends CrudRepository<cliente, Integer>{

}
