package humbe.canciones.server;


import humbe.canciones.model.entity.Usuario;

public interface IUsuario {
	
	Usuario save(Usuario usuario);
	
	Usuario findById(Integer id);
    	
	void delete(Usuario usuario);
	
}
