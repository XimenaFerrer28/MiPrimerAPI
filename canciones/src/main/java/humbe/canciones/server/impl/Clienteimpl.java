package humbe.canciones.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.API.Proyecto_Inventario.model.Producto;

import humbe.canciones.exception.*;

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
		if(cliente.getID_cancion() == null) {
			return clienteDao.save(cliente);
		}else {
			cliente exxiteCliente = clienteDao.findById(cliente.getID_cancion()).orElse(null);
			if (exxiteCliente != null) {
				exxiteCliente.setAlbum(cliente.getAlbum());
				exxiteCliente.setAño_lanzamiento(cliente.getAño_lanzamiento());
				exxiteCliente.setCompositor(cliente.getCompositor());
				exxiteCliente.setDuracion(cliente.getDuracion());
				exxiteCliente.setNombre(cliente.getNombre());
				exxiteCliente.setProductor(cliente.getProductor());
				
				return clienteDao.save(exxiteCliente);
			}else {
				throw new NotFoundException("Producto no encontrado con el ID: " + cliente.getID_cancion());
			}
		}
		
	}
	 
	@Transactional
	@Override
	public cliente findById(Integer id) {
		return clienteDao.findById(id).orElse(null);
	}
	
	
	@Override
	public void delete(cliente cliente) {
		clienteDao.delete(cliente);
	}

	@Override
	public Iterable<cliente> findAll() {
		return clienteDao.findAll();
	}
}
