package humbe.canciones.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import humbe.canciones.exception.NotFoundException;
import humbe.canciones.model.dao.CancionDao;
import humbe.canciones.model.entity.Cancion;
import humbe.canciones.server.ICancion;
@Service
public class Cancionimpl implements ICancion{
	@Autowired
	private CancionDao clienteDao;
	@Transactional
	@Override
	// este metodo crear y modifica los registros, es por eso que tomamos el id para verificar si existe el registro en caso de que no exista 
	// esto quiere decir que sera un registro nuevo
	public Cancion save(Cancion cliente) {
		if(cliente.getId_cancion() == null) {
			return clienteDao.save(cliente);
		}else {
			Cancion exxiteCliente =
			clienteDao.findById(cliente.getId_cancion()).orElse(null);
			if (exxiteCliente != null) {
				exxiteCliente.setAlbum(cliente.getAlbum());
				exxiteCliente.setAño_lanzamiento(cliente.getAño_lanzamiento(
				));
				exxiteCliente.setCompositor(cliente.getCompositor());
				exxiteCliente.setDuracion(cliente.getDuracion());
				exxiteCliente.setNombre(cliente.getNombre());
				exxiteCliente.setProductor(cliente.getProductor());
				return clienteDao.save(exxiteCliente);
			}else {
				throw new NotFoundException("Producto no encontrado con el ID: " + cliente.getId_cancion());
			}
		}
	}
	@Transactional
	@Override
	public Cancion findById(Integer id) {
		return clienteDao.findById(id).orElse(null);
	}
	@Override
	public void delete(Cancion cliente) {
		clienteDao.delete(cliente);
	}
	@Override
	public Iterable<Cancion> findAll() {
		return clienteDao.findAll();
	}
}
