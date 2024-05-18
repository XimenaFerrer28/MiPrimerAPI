package humbe.canciones.server;

import humbe.canciones.model.entity.Cancion;

public interface ICancion {
	
	Iterable<Cancion> findAll();
	
	Cancion save(Cancion cliente);
    
	Cancion findById(Integer id);
	
	void delete(Cancion cliente);
}

