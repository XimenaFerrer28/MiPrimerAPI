package humbe.canciones.server;

import humbe.canciones.model.entity.cliente;

public interface ICliente {
	
	cliente save(cliente cliente);
    
	cliente findById(Integer id);
	
	void delete(cliente cliente);
}
