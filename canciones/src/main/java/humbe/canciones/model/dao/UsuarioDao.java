package humbe.canciones.model.dao;

import org.springframework.data.repository.CrudRepository;

import humbe.canciones.model.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Integer> {

	Usuario findByEmailAndPassword(String email, String password);

	Usuario findByToken(String token);

}
