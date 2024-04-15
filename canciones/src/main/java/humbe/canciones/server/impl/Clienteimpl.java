package humbe.canciones.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import humbe.canciones.model.dao.ClienteDao;
import humbe.canciones.model.entity.cliente;
import humbe.canciones.server.ICliente;


@Service
public class Clienteimpl implements ICliente{
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Transactional
	@Override
	public cliente save(cliente cliente) {
		return clienteDao.save(cliente);
	}
	 
	
    
	@Transactional(readOnly = true)
	@Override
	public cliente findById(Integer id) {
		return clienteDao.findById(id).orElse(null);
	}
	
	@Transactional
	@Override
	public void delete(cliente cliente) {
		clienteDao.delete(cliente);
	}
}
