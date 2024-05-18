package humbe.canciones.model.dao;

import org.springframework.data.repository.CrudRepository;

import humbe.canciones.model.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Integer> {

}
