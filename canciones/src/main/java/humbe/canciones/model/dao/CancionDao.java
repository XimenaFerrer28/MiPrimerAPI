package humbe.canciones.model.dao;

import org.springframework.data.repository.CrudRepository;

import humbe.canciones.model.entity.Cancion;

public interface CancionDao extends CrudRepository<Cancion, Integer>{

}
